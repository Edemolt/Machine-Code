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

class Queue{
    private:
        Node *l, *r;
    
    public:
        Queue(){
            l = r = NULL;
        }

        ~Queue(){
            while(l){
                Node * temp = l;
                l = l->next;
                delete temp;
            }
        }
        void put(int data){
            Node * newnode = new Node(data);
            if(!(l) && (!(r))) l = r = newnode;
            else{
                r->next = newnode;
                r = newnode;
            }
        }

        int pop(){
            if(!(l)){
                cout<<"QUeue is empty\n";
                return 1e9;
            }

            int num = l->val;
            Node * temp = l;
            l = l->next;
            delete temp;

            if(!(l)) r = NULL;
            return num;
        }

        int peek(){
            if(!(l)){
                cout<<"QUeue is empty\n";
                return 1e9;
            }else{
                return l->val;
            }
        }

        void display(){
            if(!(l)){
                cout<<"QUeue is empty\n";
                return;
            }
            Node* temp = l; 
            cout << "Queue elements: ";
            while (temp) {
                cout << temp->val << " ";
                temp = temp->next;
            }
            cout << endl;
        }
};

int main() {
    Queue q;
    q.put(10);
    q.put(20);
    q.put(30);
    q.display();

    cout << "Popped: " << q.pop() << endl;
    q.display();

    cout << "Peek: " << q.peek() << endl;
    
    q.put(40);
    q.put(50);
    q.display();

    return 0;
}