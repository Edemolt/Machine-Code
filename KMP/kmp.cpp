class Solution {
    public:
        vector<int> LPS(string &str){
            int n = str.size();
            vector<int> v(n, 0);
            int j = 0, i = 1;
    
            while(i < n){
                if(str[i] == str[j]){
                    j += 1;
                    v[i] = j;
                    i += 1;
                }else{
                    if(j != 0) j = v[j-1];
                    else i += 1;
                }
            }
            return v;
        }
        int strStr(string txt, string pat) {
            int n = txt.size(), m = pat.size();
            int i = 0, j = 0;
            vector<int> lps = LPS(pat);
            while(i < n){
                if(txt[i] == pat[j]){
                    i += 1;
                    j += 1;
                    if(j == m) return i - j;
                }else if(i < n && txt[i] != pat[j]){
                    if(j > 0) j = lps[j-1];
                    else i += 1;
                }
            }
            return -1;
        }
    };