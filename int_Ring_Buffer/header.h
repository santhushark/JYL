#include <iostream>
#include <string>

using namespace std;
class Student_DB_RB{
    private:
        string name;
        int roll_no;
        Student_DB_RB *next;
    public:
        Student_DB_RB(){};
        Student_DB_RB* get_next();
        string get_name();
        int get_roll_no();
        string set_name();
        int set_roll_no();
        void set_next(Student_DB_RB*);
        void Fill_class();
};

class RB_DB_Operations:public Student_DB_RB{
    private:
        Student_DB_RB *Front, *Rear;
        int rb_sz, dnmc_rb_sz;
    public:
        RB_DB_Operations();
        int get_choice();
        char get_char();
        void set_sz();
        void Student_DB_RB_INSERT();
        void Student_DB_RB_TRAVERSE();
        void Student_DB_RB_DELETE();
};
