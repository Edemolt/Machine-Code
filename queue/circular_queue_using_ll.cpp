#include <iostream>
using namespace std;

class Node{
    public:
        int val;
        Node * next;
    
        Node(int data){
            val = data;
            next = NULL;
        }
};

class CQ{
    private:
        Node *ptr;
    
    public:
        CQ(){
            ptr = NULL;
        }

        ~CQ(){
            while(!(empty()))pop();
        }

        void push(int num){
            Node * temp = new Node(num);

            if(empty()){
                temp->next = temp;
                ptr = temp;
            }else{
                temp->next = ptr->next;
                ptr->next = temp;
                ptr = temp;
            }
        }

        int pop(){
            if(empty()){
                cout<<"Queue is empty\n";
                return 1e9;
            }

            Node * l = ptr->next;
            int val = l->val;
            
            if(l == ptr){
                delete ptr;
                ptr = NULL;
                return val;
            }else{
                ptr->next = l->next;
            }

            delete l;
            return val;
        }

        int peek(){
            if(empty()){
                cout<<"Queue is empty\n";
                return 1e9;
            }
            return ptr->next->val;
        }

        void print(){
            if(empty()){
                cout<<"Queue is empty\n";
                return;
            }

            Node * temp = ptr->next;
            cout<<"Queue -> ";
            do{
                cout<<temp->val<<"  ";
                temp = temp->next;
            }while( temp != ptr->next);
            cout<<endl;
        }

        int empty(){
            return ptr == NULL;
        }
};

int main() {
    CQ cq;
    cq.push(10);
    cq.push(20);
    cq.push(30);
    cq.print();

    cout << "popd: " << cq.pop() << endl;
    cq.print();

    cout << "Front element: " << cq.peek() << endl;

    cq.push(40);
    cq.print();
    
    return 0;
}