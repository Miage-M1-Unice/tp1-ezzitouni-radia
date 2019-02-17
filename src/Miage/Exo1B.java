package Miage;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Exo1B extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		
		System.out.println("*********Rep********* ");
		System.out.println("Repertoire : ==> " +dir);
		return FileVisitResult.CONTINUE;

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("fichier ==> " +file);
		return FileVisitResult.CONTINUE;


	}


}
