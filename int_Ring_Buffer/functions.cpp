#include "header.h"

RB_DB_Operations::RB_DB_Operations(){
    Front = NULL;
    Rear = NULL;
    dnmc_rb_sz = 0;
}

int Student_DB_RB::get_roll_no(){
        return roll_no;
}

string Student_DB_RB::get_name(){
	return name;
}

Student_DB_RB* Student_DB_RB::get_next(){
    return next;
}

string Student_DB_RB::set_name(){
    string name;
	cout<<"Enter the name of STUDENT"<<endl;
	cin>>name;
	return name;
}

int Student_DB_RB::set_roll_no(){
    int rollno;
	cout<<"Enter the ROLL_NO of STUDENT"<<endl;
	cin>>rollno;
	return rollno;
}

void Student_DB_RB::set_next(Student_DB_RB* ptr){
    next=ptr;
}

void Student_DB_RB::Fill_class(){
	name = set_name();
	roll_no = set_roll_no();
}

void RB_DB_Operations::Student_DB_RB_INSERT(){
    if(Front==Rear && Front==NULL){
        Student_DB_RB *temp = new Student_DB_RB();
        temp->Fill_class();
        Front=Rear=temp;
        Front->set_next(NULL);
        dnmc_rb_sz++;
    }
    else if(Front==Rear && Front!=NULL){
        Student_DB_RB *temp = new Student_DB_RB();
        temp->Fill_class();
        Rear=temp;
        Front->set_next(Rear);
        Rear->set_next(NULL);
        dnmc_rb_sz++;
    }
    else if(dnmc_rb_sz==rb_sz){
        Rear->set_next(Front);
        Rear=Front;
        Front=Front->get_next();
        Rear->Fill_class();
    }
    else{
        Student_DB_RB *temp = new Student_DB_RB();
        temp->Fill_class();
        Rear->set_next(temp);
        Rear=temp;
        Rear->set_next(NULL);
        dnmc_rb_sz++;
    }
}

void RB_DB_Operations::Student_DB_RB_TRAVERSE(){
    Student_DB_RB* one;
    if((Front == NULL) && (Rear == NULL)){
        cout<<"The Ring Buffer is Empty"<<endl;
    }
    else if(Front==Rear && Front!=NULL){
        one = Front;
        cout<<one->get_name()<<"\t"<<one-> get_roll_no()<<endl;
    }
    else{
        one = Front;
        while(one != Rear){
            cout<<one->get_name()<<"\t"<<one-> get_roll_no()<<endl;
            one = one->get_next();
        }
        cout<<one->get_name()<<"\t"<<one-> get_roll_no()<<endl;
    }
}

void RB_DB_Operations::Student_DB_RB_DELETE(){
    if((Front == NULL) && (Rear == NULL)){
        cout<<"The Ring Buffer is Empty"<<endl;
    }
    else{
        Student_DB_RB *one;
        if((Rear->get_next())==Front){
            one=Rear;
            one->set_next(NULL);
            one=Front;
            Front=one->get_next();
            delete one;
        }
        else if((one=Front->get_next())==Rear){
            one=Front;
            Front=Rear;
            delete one;
        }
        else if(Front==Rear){
            one=Front;
            Front=Rear=NULL;
            delete one;
        }
        else{
            one=Front;
            Front=one->get_next();
            delete one;
        }
        dnmc_rb_sz--;
    }
}

void RB_DB_Operations::set_sz(){
    do{
        cout<<"Enter valid RING_BUFFER size"<<endl;
        cin>>rb_sz;
    }while(rb_sz < 1);
}

int RB_DB_Operations::get_choice(){
    int i;
    cout<<"Choose:\n"<<"1) INSERT\t2)TRAVERSE\t3)DELETE\n"<<endl;
    cin>>i;
    cout<<"\n";
    return i;
}

char RB_DB_Operations::get_char(){
	char ch;
	cout<<"PRESS Y/y to continue and N/n to end"<<endl;
    cin>>ch;
    return ch;
}

