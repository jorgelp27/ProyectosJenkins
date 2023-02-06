
// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda del Corte Ingles.')
    scm {
        git('https://github.com/jorgelp27/jenkinsPTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('jorgelp27')
                node / gitConfigEmail('jorgeperez793@gmail.com')
        }
    }
    triggers {
     //   scm('H/5 * * * *')
        githubPush()
    }
    
    steps {
        shell("bash ./build/install.sh")
    }
}



