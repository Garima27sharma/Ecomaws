node
{
  stage('SCM Checkout'){
    
    git 'https://github.com/Garima27sharma/Ecomaws'
  }
  stage('Compile-Package')
  {
    def mvnHome = tool name: 'maven', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
}
