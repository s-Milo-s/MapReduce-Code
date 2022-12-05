echo "Deleting .jar and .class files"
rm *.class rm *.jar
echo "Deleting hdfs output file"  
hdfs dfs -rm -r "$1"
