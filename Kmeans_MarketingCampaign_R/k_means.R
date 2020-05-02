getwd()
setwd("/home/santosh/Desktop/DATA_SCIENCE/nineth_week")
# Bussiness problem : identify potential customers for marketing campaign based on 1) Annual income 2) Spending score
kmeansData = read.csv("Kmeans_data.csv", na.strings = "")
#find number of clusters
campaign_data = kmeansData[4:5]
set.seed(123)
wcss = vector()
for (i in 1:10)
wcss[i] = sum(kmeans(campaign_data, i)$withinss)
plot(1:10, wcss, type = "b", xlab = "no of clusters", ylab = "wcss")
help(plot)
install.packages("cluster")
km = kmeans(campaign_data, 4)
cluster_no = km$cluster
cluster_campaigndata = cbind(campaign_data,cluster_no)
help(cluster)
#google for clusplot for proper syntax, package data is not clear/sufficient
clusplot(campaign_data, km$cluster, lines = 0, shade = TRUE, color = TRUE, labels = 2, xlab = "Income", ylab = "spending score")

