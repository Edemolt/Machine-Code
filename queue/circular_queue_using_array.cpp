#include <iostream>
using namespace std;

class CQueue{
    private:
        int *arr;
        int l, r;
        int sz;
        int cnt;

    public:
        CQueue(int sz){
            this->sz = sz;
            arr = new int[sz];
            l = 0, r = -1;
            cnt = 0;
        }

        ~CQueue(){
            delete[] arr;
        }

        void push(int num){
            if(full()){
                cout<<"Queue is full \n";
                return;
            }

            r = (r + 1) % sz;
            arr[r] = num;
            cnt += 1;
        }

        int pop(){
            if(empty()){
                cout<<"Queur is empty\n";
                return 1e9;
            }

            int num = arr[l];
            l = (l + 1)%sz;
            cnt -= 1;
            return num;
        }

        int peek(){
            if(empty()){
                cout<<"Queue is empty\n";
                return 1e9;
            }

            return arr[l];
        }

        void print(){
            if(empty()){
                cout<<"Queue is empty\n";
                return;
            }

            cout<<"Elements of queue -> ";
            for(int i = 0; i < cnt; i++) cout<<arr[ (l + i) % sz]<<"  ";
            cout<<endl;
        }

        int full(){
            return cnt == sz;
        }

        int empty(){
            return cnt == 0;
        }
};

int main() {
    CQueue cq(5);
    
    cq.push(10);
    cq.push(20);
    cq.push(30);
    cq.push(40);
    cq.print();
    
    cout << "popd: " << cq.pop() << endl;
    cq.print();

    cq.push(50);
    cq.push(60); // This should work in circular fashion if there's space.
    cq.print();

    cout << "Front element: " << cq.peek() << endl;
    
    return 0;
}