#include <iostream>
using namespace std;

class Node{
    public:
        int val;
        Node * next;
    
    Node(int val){
        this->val = val;
        next = NULL;
    }
};

class Stack{
    private:
        Node * top;
    
    public:
    
        Stack(){
            top = NULL;
        }

        ~Stack(){
            while(!(empty())) pop();
        }

        void push(int num){
            Node * newnode = new Node(num);
            newnode->next = top;
            top = newnode;
        }

        int pop(){
            if(top == NULL){
                cout<<"Stack is empty\n";
                return 1e9;
            }

            int ans = top->val;
            Node * temp = top;
            top = temp->next;
            delete temp;
            return ans;
        }

        int empty(){
            return top == NULL;
        }

        int peek(){
            if(top == NULL){
                cout<<"Stack is empty\n";
                return 1e9;
            }

            return top->val;
        }

        void print(){
            if(empty()){
                cout<<"Stack is empty\n";
                return;
            }

            cout<<"Stack elements -> ";
            Node * temp = top;
            while(temp){
                cout<<temp->val<<" ";
                temp = temp->next;
            }
            cout<<endl;
        }
};

int main(){
    Stack st;
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);

    st.print();
    for(int i = 0; i < 5; i++){
        cout<<st.pop()<<"  ";
        st.print();
    }
}