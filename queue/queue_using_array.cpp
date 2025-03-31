#include<iostream>
using namespace std;

class Queue{
    private:
        int * arr;
        int l, r;
        int sz;

    public:
        Queue(int size){
            sz = size;
            l = 0;
            r = -1;
            arr = new int[sz];
        }

        ~Queue(){
            delete[] arr;
        }

        void push(int num){
            if(r == sz - 1){
                cout<<"Queue is full\n";
                return;
            }
            if(l == -1) l = 0; 
            r += 1;
            arr[r] = num;
        }

        int pop(){
            if(l == -1 || l > r){
                cout<<"Queue is empty {pop}\n";
                return 1e9;
            }
            int num = arr[l];
            l += 1;
            if(l > r) {
                l =0; 
                r = -1;
            }
            return num;
        }

        int peek(){
            if(l == -1 || l > r){
                cout<<"Queue is empty {peek}\n";
                return 1e9;
            }
            return arr[l];
        }

        void display(){
            if(l == -1 || l > r) cout<<"Queue is empty {dispaly}\n";
            else{
                for(int i = l; i <= r; i++) cout<<arr[i]<<" ";
                cout<<endl;
            } 
        }
};

int main() {
    Queue q(5);
    q.push(10);
    q.push(20);
    q.push(30);
    q.display();

    cout << "Popped: " << q.pop() << endl;
    q.display();

    cout << "Peek: " << q.peek() << endl;
    
    q.push(40);
    q.push(50);
    q.push(60);
    q.display();

    while (q.pop() != 1e9); // Empty the queue

    // q.display(); // Should print "Queue is empty"
    
    return 0;
}