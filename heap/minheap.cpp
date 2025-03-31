#include <iostream>
#include <vector>

using namespace std;

class PQ{
    private:
        vector<int> heap;
        int parent(int ind){
            return (ind - 1)/2;
        }

        int lchild(int ind){
            return 2 * ind + 1;
        }

        int rchild(int ind){
            return 2 * ind + 2;
        }

        void swap(int a, int b){
            heap[a] = heap[a] + heap[b];
            heap[b] = heap[a] - heap[b];
            heap[a] = heap[a] - heap[b];
        }

        void heapifyUp(int ind){
            while(ind && heap[parent(ind)] > heap[ind]){
                swap( ind, parent(ind));
                ind = parent(ind);
            }
        }

        void heapifyDown(int ind){
            int sz = heap.size();
            while(1){
                int l = lchild(ind);
                int r = rchild(ind);
                int mn = ind;

                if(l < sz && heap[l] < heap[mn]) mn = l;
                if(r < sz && heap[r] < heap[mn]) mn = r;

                if(mn != ind){
                    swap( ind, mn);
                    ind = mn;
                }else break;
            }
        }

        public:
            void push(int num){
                heap.emplace_back(num);
                heapifyUp( heap.size() - 1);
            }

            void pop(){
                if(heap.empty()){
                    cout<<"Heap is empty\n";
                }else{
                    heap[0] = heap.back();
                    heap.pop_back();
                    if(!(heap.empty())) heapifyDown(0);
                }
            }

            int top(){
                if(heap.empty()){
                    cout<<"Heap is empty\n";
                    return 1e9;
                }
                return heap.front();    
            }

            int empty(){
                return heap.empty();
            }
};


int main() {
    PQ mh;
    mh.push(10);
    mh.push(4);
    mh.push(15);
    mh.push(1);

    while (!mh.empty()) {
        std::cout << mh.top() << " ";
        mh.pop();
    }
    // Output: 1 4 10 15
    return 0;
}