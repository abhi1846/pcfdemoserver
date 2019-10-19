package com.example.csvbatch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.example.csvbatch.model.Employee;
 

 
@Configuration
@EnableBatchProcessing
public class BatchConfigNew
{
	Logger logger=LoggerFactory.getLogger(BatchConfigNew.class);
	private static final String OVERRIDDEN_BY_EXPRESSION = null;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
     
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
 
    @Value("input/inputData*.csv")
    private Resource[] inputResources;
   // @Value("#{jobParameters[pass]}")
    //public String passed;
    //private Resource outputResource = new FileSystemResource("output/outputData1"+passed+".csv");
 
    @Bean
    @StepScope
    public FlatFileItemWriter<Employee> writerOther(@Value("#{jobParameters[pass]}") String passed)
    {
        logger.info("THE PASSED VALUE IS: "+passed);
        Resource outputResource = new FileSystemResource("output/outputData"+passed+".csv");
        //Create writer instance
        FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<>();

        
        String exportFileHeader = "ID,FIRST NAME,LAST NAME";
        StringHeaderWriter headerWriter = new StringHeaderWriter(exportFileHeader);
        writer.setHeaderCallback(headerWriter);
        //Set output file location
        writer.setResource(outputResource);
         
        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(true);
         
        //Name field values sequence based on object properties
        writer.setLineAggregator(new DelimitedLineAggregator<Employee>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<Employee>() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
            }
        });
        return writer;
    }
 
    @Bean("JOB2")
    public Job readCSVFilesJobOther() {
        return jobBuilderFactory
                .get("readCSVFilesJobOther")
                .incrementer(new RunIdIncrementer())
                .start(step2())
                .build();
    }
 
    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2").<Employee, Employee>chunk(5)
                .reader(multiResourceItemReaderNew())
                .writer(writerOther(OVERRIDDEN_BY_EXPRESSION))
                .build();
    }
 
    @Bean
    //@Scope("step")
    public MultiResourceItemReader<Employee> multiResourceItemReaderNew()
    {
        MultiResourceItemReader<Employee> resourceItemReader = new MultiResourceItemReader<Employee>();
        resourceItemReader.setResources(inputResources);
        resourceItemReader.setDelegate(readerNew());
        return resourceItemReader;
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader<Employee> readerNew()
    {
        //Create reader instance
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
         
        //Set number of lines to skips. Use it if file has header rows.
        reader.setLinesToSkip(1);  
         
        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper() {
            {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
                //Set values in Employee class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
                    {
                        setTargetType(Employee.class);
                    }
                });
            }
        });
        return reader;
    }
}