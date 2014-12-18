echo "calling build"
mvn clean install
echo "maven build is done"
cp /home/kishore/.m2/repository/com/college/portal/AdminCollegePortal/0.0.1-SNAPSHOT/*.war /home/kishore/jbosseap6.3/standalone/deployments/

echo "copy is finished"

