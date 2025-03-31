#include <iostream>
#include <vector>

using namespace std;

class PQ {
private:
    vector<int> heap;
    
    int parent(int ind) {
        return (ind - 1) / 2;
    }

    int lchild(int ind) {
        return 2 * ind + 1;
    }

    int rchild(int ind) {
        return 2 * ind + 2;
    }

    void swap(int a, int b) {
        heap[a] = heap[a] + heap[b];
        heap[b] = heap[a] - heap[b];
        heap[a] = heap[a] - heap[b];
    }

    // For max heap, the parent's value should be >= the child's value.
    void heapifyUp(int ind) {
        while (ind && heap[parent(ind)] < heap[ind]) {
            swap(ind, parent(ind));
            ind = parent(ind);
        }
    }

    // For max heap, we want the larger child.
    void heapifyDown(int ind) {
        int sz = heap.size();
        while (true) {
            int l = lchild(ind);
            int r = rchild(ind);
            int mx = ind;

            if (l < sz && heap[l] > heap[mx])
                mx = l;
            if (r < sz && heap[r] > heap[mx])
                mx = r;

            if (mx != ind) {
                swap(ind, mx);
                ind = mx;
            } else {
                break;
            }
        }
    }

public:
    void push(int num) {
        heap.emplace_back(num);
        heapifyUp(heap.size() - 1);
    }

    void pop() {
        if (heap.empty()) {
            cout << "Heap is empty\n";
        } else {
            heap[0] = heap.back();
            heap.pop_back();
            if (!heap.empty()) {
                heapifyDown(0);
            }
        }
    }

    int top() {
        if (heap.empty()) {
            cout << "Heap is empty\n";
            return -1; // Returning -1 as an error code
        }
        return heap.front();
    }

    bool empty() {
        return heap.empty();
    }
};

int main() {
    PQ mh;
    mh.push(10);
    mh.push(4);
    mh.push(15);
    mh.push(1);

    // Expected Output: 15 10 4 1
    while (!mh.empty()) {
        cout << mh.top() << " ";
        mh.pop();
    }
    
    return 0;
}
