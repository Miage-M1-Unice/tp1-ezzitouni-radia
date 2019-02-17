package Miage;

import java.io.File;
import java.io.FilenameFilter;

public class FiltreExterne implements FilenameFilter{
	
	private String extension;
	
	public FiltreExterne(String ext) {
			this.extension= ext.toLowerCase();
		}

	@Override
	public boolean accept(File arg0, String arg1) {
	
		return arg1.toLowerCase().endsWith(extension);
	}

}
