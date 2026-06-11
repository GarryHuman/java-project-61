# Цель для запуска приложения
run:
	java -jar ./build/libs/java-project-61-1.0-SNAPSHOT.jar

# Объявление цели фейковой (чтобы make не искал файл с именем 'run')
.PHONY: run