# test-task

QA Automation Test
We have a site for ticketing system http://safebreach-qa-test.dev.sbops.com/
The test is
Open a new ticket and post it
Then login to http://safebreach-qa-test.dev.sbops.com/scp/login.php as devops:123456a
Agent Panel -> Tickets and validate that the ticket is there
Check that the ticket exist in the database, mysql -u root -p and the password is 123456a
The ssh user is ubuntu
Create automation for the test
Think of a way to test each part (UI and DB) as an atomic unit.
If you have any questions please don't hesitate to call me
P.S attach is the ssh key
