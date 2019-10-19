package com.example.csvbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@SpringBootApplication
@EnableScheduling
public class CsvbatchApplication {
	Logger logger=LoggerFactory.getLogger(CsvbatchApplication.class);
    @Autowired
    JobLauncher jobLauncher;
      
    @Autowired
    @Qualifier("JOB1")
    Job job1;

    @Autowired
    @Qualifier("JOB2")
    Job job2;
    
    
    public static void main(String[] args)
    {
        SpringApplication.run(CsvbatchApplication.class, args);
    }
      
    @Scheduled(cron = "0 */1 * * * ?")
    public void perform() throws Exception
    {
    	int i=3;
		/* for(int i=1;i<=count;i++) { */
            JobParameters params = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .addString("value", String.valueOf(i))
                    .toJobParameters();
            jobLauncher.run(job1, params);
		/* } */

    }
    @Scheduled(cron = "0 */2 * * * ?")
    public void performNew() throws Exception
    {
    	int i=1;
    	/*for(i=1;i<=3;i++) {*/
    		logger.info("VALUE OF I: "+i + "and "+ String.valueOf(i));
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .addString("pass", Integer.toString(i))
                    .toJobParameters();
            jobLauncher.run(job2, jobParameters);
		/* } */

    }
}
