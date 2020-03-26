jenkins = Jenkins.instance

 Calendar after = Calendar.getInstance()
 Calendar before = Calendar.getInstance()
 //set(int year, int month, int date, int hourOfDay, int minute,int second)
 after.set(2020,2,1,0,0,0)
 before.set(2020,4,30,0,0,0)
 println "Jobs executed between " + after.getTime() + " - " + before.getTime()
 for (job in jenkins.getAllItems(Job.class)) {
   for(Run run in job.getLastSuccessfulBuild()){
         if (run.getTimestamp()?.before(before) && run.getTimestamp()?.after(after)) {
                 println "" + run.getResult() + " " + job.name + " " + job.getLastBuild().getTime()
         }
   }
 }
