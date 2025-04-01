#include <iostream>
using namespace std;


class DQ{
    private:
        int *arr;
        int l, r, sz, capacity;

    public:
        DQ(int cap){
            capacity = cap;
            arr = new int[capacity];
            l = -1;
            r = -1;
            sz = 0;
        }

        ~DQ(){
            delete[] arr;
        }

        int full(){
            return sz == capacity;
        }

        int empty(){
            return sz == 0;
        }

        void push_front(int num){
            if(full()){
                cout<<"Dequeue is full\n";
                return;
            }
            
            if(empty()) l = r = 0;
            else l = (l - 1 + capacity) % capacity;
            arr[l] = num;
            sz += 1;
        }
        
        void push_back(int num){
            if(full()){
                cout<<"Dequeue is full\n";
                return;
            }

            if(empty()) l = r = 0;
            else r = (r + 1) % capacity;
            arr[r] = num;
            sz += 1;
        }

        void pop_front(){
            if(empty()){
                cout<<"Dequeue is empty\n";
                return;
            }

            if(l == r) l = r = -1;
            else l = (l + 1) % capacity;
            sz -= 1;
        }

        void pop_back(){
            if(empty()){
                cout<<"Dequeue is empty\n";
                return;
            }

            if(l == r) l = r = -1;
            else r = (r -1 + capacity) % capacity;
            sz -= 1;
        }

        int front(){
            if(empty()){
                cout<<"Dequeue is empty\n";
                return -1;
            }

            return arr[l];
        }

        int back(){
            if(empty()){
                cout<<"Dequeue is empty\n";
                return -1;
            }
            return arr[r];
        }
};

int main() {
    DQ dq(5);
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