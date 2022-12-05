import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Combo {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Error");
            System.exit(-1);
        }
        Job job1 = new Job();
        job1.setJarByClass(Combo.class);
        job1.setJobName("Combo");
        job1.setMapperClass(ComboMapper.class);
        job1.setReducerClass(ComboReducer.class); // change these
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job1, new Path(args[0]));
        FileOutputFormat.setOutputPath(job1, new Path(args[1]));
        job1.setNumReduceTasks(1);
        System.exit(job1.waitForCompletion(true) ? 0 : 1);
    }
}
