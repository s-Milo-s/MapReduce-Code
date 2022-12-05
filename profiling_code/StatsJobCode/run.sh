#This script takes in 
#1:Base MapReduce Driver name
#2:: Base Job1 MAP and Reduce name 
#3: Base Job2 MAP and Reduce name
#4: Input file location in hdfs
#5: Ouput location in HDFS
echo "Starting Script"

echo "Compiling Code"
javac -classpath `yarn classpath` -d . ${1}Mapper.java
javac -classpath `yarn classpath` -d . ${1}Reducer.java
javac -classpath `yarn classpath`:. -d . ${1}.java
jar -cvf ${1}.jar ${1}Mapper.class ${1}Reducer.class ${1}.class

echo "Runnung Job"
hadoop jar ${1}.jar "$1" "$2" "/user/mm9626/${3}"

#example input :
# sh run.sh Statistics Combo Stats Project/input/Clean-Data Project/statsOutput
