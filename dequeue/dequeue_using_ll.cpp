#include <iostream>
using namespace std;

class Node{
    public:
        int val;
        Node * next, *prev;

        Node(int val){
            this->val = val;
            next = prev = NULL;
        }
};

class DQ{
    private:
        Node * l, *r;
        int sz;

    public:
        DQ(){
            l = r = NULL;
            sz = 0;
        }

        int empty(){
            return sz == 0;
        }

        void push_front(int num){
            Node * newnode = new Node(num);

            if(empty()){
                l = r = newnode;
            }else{
                newnode->next = l;
                l->prev = newnode;
                l = newnode;
            }
            sz += 1;
        }

        void push_back(int num){
            Node * newnode = new Node(num);

            if(empty()){
                l = r = newnode;
            }else{
                newnode->prev = r;
                r->next = newnode;
                r = newnode;
            }
            sz += 1;
        }

        void pop_front(){
            if(empty()){
                cout<<"DQ is empty\n";
                return;
            }

            Node * temp = l;
            l = l->next;
            if(l) l->prev = NULL;
            else r = NULL;
            delete temp;
            sz -= 1;
        }

        void pop_back(){
            if(empty()){
                cout<<"DQ is empty\n";
                return;
            }

            Node * temp = r;
            r = r->next;
            if(r) r->next = NULL;
            else l = NULL;
            delete temp;
            sz -= 1;
        }

        int front(){
            if(empty()){
                cout<<"DQ is empty\n";
                return -1;
            }
            return l->val;
        }

        int back(){
            if( empty()){
                cout<<"DQ is empty\n";
                return -1;
            }
            return r->val;
        }
};

int main() {
    DQ dq;
    dq.push_back(10);
    dq.push_back(20);
    dq.push_front(5);
    dq.push_front(1);
    dq.push_back(30);

    cout << "Front: " << dq.front() << endl;
    cout << "Rear: " << dq.back() << endl;
    
    dq.pop_front();
    cout << "After deleting front, new front: " << dq.front() << endl;
    
    dq.pop_back();
    cout << "After deleting rear, new rear: " << dq.back() << endl;
    
    return 0;
}
