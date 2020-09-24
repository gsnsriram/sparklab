package dev.ouno.sparklab.controller;

import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ouno.sparklab.helper.WordCount;
import dev.ouno.sparklab.model.Count;
import dev.ouno.sparklab.model.JobInfo;

@RestController
@RequestMapping("jobs")
public class JobInvoker {
    @Autowired private WordCount wordCount;
    
	@GetMapping("/enrich")
	public JobInfo enrich() {
		return new JobInfo(1, "Enrich", ExitStatus.COMPLETED.getExitCode());
	}

    @GetMapping("wordcount")
    public List<Count> words() {
        return wordCount.count();
    }
	
}
