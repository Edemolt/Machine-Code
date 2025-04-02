#include <iostream>
using namespace std;
#include <unordered_map>

class Node{
    public:
        int key, val;
        Node * next, * prev;
        int cnt;
        Node(int key, int val){
            this->key = key;
            this->val = val;
            next = NULL;
            prev = NULL;
            cnt = 1;
        }
};

class List{
    public:
        int size;
        Node * l, * r;

        List(){
            l = new Node(0, 0);
            r = new Node(0, 0);
            l->next = r;
            r->prev = l;
            size = 0;
        }

        void add(Node * node){
            node->next = l->next;
            node->prev = l;
            l->next = node;
            node->next->prev = node;
            size += 1;
        }

        void remove(Node * node){
            Node * prev = node->prev;
            Node * next = node->next;
            next->prev = prev;
            prev->next = next;
            size -= 1;
        }
};

class LFUCache {
public:

    unordered_map<int, Node *> mp;
    unordered_map<int, List *> freqList;

    int maxsize, currsize, minfreq;

    LFUCache(int capacity) {
            maxsize = capacity;
            currsize = 0;
            minfreq = 0;
            freqList[1] = new List();
    }

    void updateFreq(Node * node){
        mp.erase( node->key);

        freqList[ node->cnt]->remove( node);

        if(node->cnt == minfreq && !( freqList[ node->cnt]->size))
            minfreq += 1;

        int nextCnt = node->cnt + 1;
        if(freqList.find(nextCnt) == freqList.end())
            freqList[nextCnt] = new List();  // Create only if not existing

        node->cnt++;
        freqList[nextCnt]->add(node);
        mp[node->key] = node;
    }
    
    int get(int key) {
        if(mp.find(key) != mp.end()){
            Node * node = mp[key];
            int val = node->val;
            updateFreq(node);
            return val;
        }else return -1;
    }
    
    void put(int key, int val) {
        if(maxsize == 0) return ;

        if( mp.find(key) != mp.end()){
            Node * node = mp[key];
            node->val = val;
            updateFreq( node);
        }else{
            if(currsize == maxsize){
                List * list = freqList[minfreq];
                Node * toDelete = list->r->prev; // The least frequently used node
                mp.erase(toDelete->key);
                list->remove(toDelete);
                delete toDelete; // Avoid memory leak
                currsize--;
            }

            currsize += 1;
            
            minfreq = 1;
            List * listfreq = new List();

            if( freqList.find( minfreq) != freqList.end())
                listfreq = freqList[ minfreq];

            Node * node = new Node(key, val);
            listfreq->add( node);
            mp[key] = node;
            freqList[ minfreq] = listfreq; 
        }

    }
};


int main() {
    LFUCache cache(2);  // Capacity of 2

    cache.put(1, 10);
    cache.put(2, 20);
    cout << cache.get(1) << endl; // Expected: 10

    cache.put(3, 30);  // Evicts key 2 (LFU)
    cout << cache.get(2) << endl; // Expected: -1 (not found)
    cout << cache.get(3) << endl; // Expected: 30

    cache.put(4, 40);  // Evicts key 1 (LFU)
    cout << cache.get(1) << endl; // Expected: -1 (not found)
    cout << cache.get(3) << endl; // Expected: 30
    cout << cache.get(4) << endl; // Expected: 40

    return 0;
}
