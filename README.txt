-Describe your directories and files, step by step, how to build your code, how to run your code, where to find results of a run.

-There are 7 map reduce jobs within this folder the clean job is meant to be run on the raw data
which can be found in the peel file /home/mm9626/HW7/Property_Valuation_and_Assessment_Data.csv
count recs job can also be run on this. The remaining 5 jobs should all be run on the output
of the clean job. This can be produced or found in /home/mm9626/Clean-Data.

-How to run all files: contained in each directory ending with -code ect. ValPerBldType-Code
is a run.sh file. This file should be run within the file with three arguments.
1. The prefix to the job name ex. ValPerBldType would compile and make a jar file with all files containing ValPerBldType
   So it would make ValPerBldTypeMapper.class, ValPerBldTypeReducer.class, and ValPerBldType.class and ValPerBldType.jar

2. the second argument is the location of the data in hdfs that you want the job to process 
i.e Project/input/Clean-Data

3. The third argument is where you want the data to go in HDFS 
i.e Project/statsOutput3
NOTE: this must be changed for your uses as the script file referances MY hdfs location in my script file it say "/user/mm9626/${3}"
This prefix must be changed for your user name 

Once all these steps are complete you can run the command and the job will compile and hopefully run 

ex. sh run.sh Stats Project/ComboOutput/output Project/statsOutput3

AGAIN NOTE: you must go into the script file and edit the run.sh to refferance your username


Directores in etl_code

1.Cleaning-code 
-Contains two jobs countRecs and Cleaning
-cleaning is responsible for cleaning raw data and countRecs counts number of records

2. ValPerBuildingType
-This directory contains one job ValPerBuilding which outputs a average valuation for a building type for each year 

3. ValPerYear
-This directory contains one job ValPerYear which outputs the average valuation of all buildings per year

4. ValPerZip
-This directory contains one job ValPerZip which outputs the average valuation of all building within a given zip-code per year

5. ZipVBuildingType 
-This directory contains one job ZipVBuildingType which outputs the average valuations of for each building type for each zip per year

Directories in profiling_code

1. StatsJobCode
-Contains two jobs Combo and Stats
-Combo is resposibles for taking clean data and outputing an intermide step 
-This intermidete step should be fed to stats as input and this will output the final result of mean and medain percent change over all zip codes

  
