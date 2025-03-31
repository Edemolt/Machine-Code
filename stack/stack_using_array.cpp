#include <iostream>
using namespace std;

class Stack{
    private:
        int * arr;
        int top;
        int size;
    
    public:
        Stack(int sz){
            size = sz;
            arr = new int[sz];
            top = -1;
        }

        ~Stack(){
            delete[] arr;
        }

        void push(int num){
            if(top == size - 1){
                cout<<"stack is full\n";
                return;
            }
            top += 1;
            arr[top] = num;
        }

        int pop(){
            if(top == -1){
                cout<<"stack is empty\n";
                return 1e9;
            }
            top -= 1;
            return arr[top + 1];
        }

        int peek(){
            if(top == -1){
                cout<<"stack is empty\n";
                return 1e9;
            }
            return arr[top];
        }

        int empty(){
            return top == -1;
        }

        void print(){
            cout<<"printing from top to bottom\n";

            for(int i = top; i >= 0; i--) cout<<arr[i]<<"  ";
            cout<<endl;
        }
};


int main(){
    Stack st(10);
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);
    st.push(6);
    st.push(7);
    st.push(8);
    st.push(9);
    st.push(10);
    cout<< st.peek()<<endl;
    st.print();
    cout<<st.pop()<<endl;
    st.print();
    
    
}