#include <iostream>
#include <unordered_map>
using namespace std;

class LL{
    public:
        int key, val;
        LL * next, * prev;
        LL(){
            key = -1;
            val = -1;
            next = NULL;
            prev = NULL;
        }

        LL(int key, int val){
            this->key = key;
            this->val = val;
            next = NULL;
            prev = NULL;
        }
};

class LRUCache {
public:
    int sz;
    LL * l, *r;
    unordered_map<int, LL *> mp;
    
    LRUCache(int capacity) {
        sz = capacity;
        l = new LL();
        r = new LL();
        l->next = r;
        r->prev = l;

    }

    void add(LL * node){
        node->next = l->next;
        node->prev = l;
        l->next = node;
        node->next->prev = node;
    }

    void remove(LL * node){
        LL * prev = node->prev;
        LL * nextnode = node->next;
        prev->next = nextnode;
        nextnode->prev = prev;
    }
    
    int get(int key) {
        if(mp.find(key) != mp.end()){
            LL * node = mp[key];
            remove(node);
            add(node);
            return node->val;
        } else return -1;
    }
    
    void put(int key, int val) {
       if(mp.find(key) != mp.end()){
            LL * node = mp[key];
            node->val = val;
            remove(node);
            add(node);
       }else{
        if(mp.size() == sz){
            LL * temp = r->prev;
            remove(temp);
            mp.erase(temp->key);
            delete temp;
        }

        LL * newnode=  new LL(key, val);
        add(newnode);
        mp[key] = newnode;
       }
    }
};


int main() {
    LRUCache cache(2); // Cache with capacity 2

    cache.put(1, 10);
    cache.put(2, 20);
    cout << "Get 1: " << cache.get(1) << endl; // Returns 10

    cache.put(3, 30); // Evicts key 2
    cout << "Get 2: " << cache.get(2) << endl; // Returns -1 (not found)

    cache.put(4, 40); // Evicts key 1
    cout << "Get 1: " << cache.get(1) << endl; // Returns -1 (not found)
    cout << "Get 3: " << cache.get(3) << endl; // Returns 30
    cout << "Get 4: " << cache.get(4) << endl; // Returns 40
    
    return 0;
}
