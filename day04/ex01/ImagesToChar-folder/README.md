скомпилить проект


    javac -d target src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/ReaderFile.java && cp -r src/resources/ target/resources/


сжать в jar проект


    jar -cmf src/manifest.txt ./target/images-to-chars-printer.jar -C target .


запустить
    
    java -jar target/images-to-chars-printer.jar white=0 black=.
    
аргументы для запуска

    Символ белого цвета     white
    Символ черного цвета    black
    
    