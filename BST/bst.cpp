#include <iostream>
using namespace std;

class Node{
    public:
        int val;
        Node * left;
        Node * right;

        Node(int val){
            this->val = val;
            left = NULL;
            right = NULL;
        }
};

class BST{
    public:
        Node * root;

        BST(){
            root = NULL;
        }

        Node * insert(Node * node, int val){
            if(!(node)) return new Node(val);

            if(val < node->val) node->left = insert( node->left, val);
            else node->right = insert( node->right, val);

            return node;
        }

        void insert(int val){
            root = insert(root, val);
        }

        int find(Node * node, int val){
            if(!(node)) return 0;
            if(node->val == val) return 1;

            return val < node->val ? find( node->left, val) : find( node->right, val); 
        }    

        int find(int val){
            return find( root, val);
        }


        Node * findMin(Node * node){
            while(node->left) node = node->left;
            return node;
        }

        int findMin(){
            return ( findMin(root))->val;
        }

        Node * remove( Node * node, int val){
            if(!(node)) return NULL;

            if(val < node->val) node->left = remove( node->left, val);
            else if(val > node->val) node->right = remove( node->right, val);
            else{
                if(!( node->left)){
                    Node * temp = node->right;
                    delete node;
                    return temp;
                }else if(!( node->right)){
                    Node * temp = node->left;
                    delete node;
                    return temp;
                }

                Node * temp = findMin(node->right);
                node->val = temp->val;
                node->right = remove( node->right, temp->val);
            }

            return node;
        }

        void remove( int val){
            root = remove( root, val);
        }

        int getheight( Node * node){
            if(!(node)) return 0;
            return 1 + max( getheight( node->left), getheight(node->right));
        }

        int height(){
            return getheight(root);
        }
};


int main() {
    BST tree;
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(2);
    tree.insert(7);

    cout << "Find 7: " << (tree.find(7) ? "Found" : "Not Found") << endl;
    cout << "Find 20: " << (tree.find(20) ? "Found" : "Not Found") << endl;
    cout << "Minimum value: " << tree.findMin() << endl;
    cout << "Height of tree: " << tree.height() << endl;
    
    tree.remove(5);
    cout << "After removing 5, Minimum value: " << tree.findMin() << endl;
    cout << "After removing 5, Height of tree: " << tree.height() << endl;
    
    tree.remove(10);
    tree.remove(15);
    cout << "After removing 10,15, Height of tree: " << tree.height() << endl;

    
    return 0;
}