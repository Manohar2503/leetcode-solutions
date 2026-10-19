class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
        Arrays.fill(dist[i],(int)1e9);
        dist[i][i]=0;}
            for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            dist[u][v]=w;
            dist[v][u]=w;}
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(dist[j][i]+dist[i][k]<dist[j][k])
                    dist[j][k]=dist[j][i]+dist[i][k];
                }
            }
        }
        int min=n;
        int res=-1;
        for(int i=0;i<n;i++){
            int reach=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=distanceThreshold)
                reach++;
            }
            if(reach<=min){
                min=reach;
                res=i;
            }
        }
        return res;
    }
}