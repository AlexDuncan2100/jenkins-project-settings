job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on githubrep")
    scm {
        git("https://github.com/clarusway-aws-devops/java-tomcat-sample-main.git", 'main')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven{
            goals('clean package')
            rootPOM('pom.xml')
            mavenInstallation('maven-3.9.5')
        }
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}
