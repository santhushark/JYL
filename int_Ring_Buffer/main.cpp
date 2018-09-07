#include "header.h"
using namespace std;

int main()
{
    int choice;
	char ch;
	cout<<"RING BUFFER"<<endl;
	RB_DB_Operations Ring_Buffer;
	Ring_Buffer.set_sz();
    do{
        choice = Ring_Buffer.get_choice();
        switch(choice){
            case 1: Ring_Buffer.Student_DB_RB_INSERT();break;
            case 2: Ring_Buffer.Student_DB_RB_TRAVERSE();break;
            case 3: Ring_Buffer.Student_DB_RB_DELETE();break;
            default: cout<<"There is no operation associated with the number you have entered\n";break;
        }
        ch=Ring_Buffer.get_char();
	}while(ch=='Y' || ch=='y');
	return 0;
}

