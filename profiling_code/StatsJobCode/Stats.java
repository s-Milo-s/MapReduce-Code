import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Stats {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Error");
            System.exit(-1);
        }
        Job job2 = new Job();
        job2.setJarByClass(Stats.class);
        job2.setJobName("Stats");
        job2.setMapperClass(StatsMapper.class);
        job2.setReducerClass(StatsReducer.class); // change these
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job2, new Path(args[0]));
        FileOutputFormat.setOutputPath(job2, new Path(args[1]));
        job2.setNumReduceTasks(1);
        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }
}
