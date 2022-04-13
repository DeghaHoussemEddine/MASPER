package ClassHelprs;

import java.io.File;
import java.util.Formatter;
import java.io.*;

public class file {

	public String arg[];
	public boolean b;

	public file() {
	};

	public void creat_file(String str) {

		final Formatter x;
		try {
			File f = new File(str);
			if (f.exists()) {
			}

			else {
				x = new Formatter(f);
				x.close();
			}
		} catch (Exception e) {

		}
	}

	public boolean delatfile(String str) {
		try {
			File f = new File(str);
			if (f.exists()) {
				f.delete();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void hide_FileOrFolder(String str) {
		File f = new File(str);
		try {
			Runtime.getRuntime().exec("attrib +a +s +h \"" + f.getAbsolutePath().toString() + "\"");
		} catch (Exception e) {
		}
	};

	public void unhide_FileOrFolder(String str) {
		File f = new File(str);
		try {
			Runtime.getRuntime().exec("attrib +a +s -h \"" + f.getAbsolutePath().toString() + "\"");
		} catch (Exception e) {
		}
	}

	public String[] Read_from_file(String str) {
		String arg[] = new String[calcule(str)];
		int i = 0;
		try {
			File f;
			f = new File(str);
			FileInputStream fs = null;
			InputStreamReader in = null;
			BufferedReader br = null;
			fs = new FileInputStream(f);
			in = new InputStreamReader(fs, "UTF8");
			br = new BufferedReader(in);
			String s;
			while ((s = br.readLine()) != null) {
				if (!s.equals("")) {
					arg[i] = s;
					i++;
				}
			}
			fs.close();
			in.close();
			br.close();
		} catch (Exception e) {
		}
		return arg;
	}

	public String[] Read_from_file_till(String str, int x) {
		String arg[] = new String[x + 200];
		int i = 0;
		try {
			File f;
			f = new File(str);
			FileInputStream fs = null;
			InputStreamReader in = null;
			BufferedReader br = null;
			fs = new FileInputStream(f);
			in = new InputStreamReader(fs, "UTF8");
			br = new BufferedReader(in);
			String s;
			for (int j = 0; j < x; j++) {

				s = br.readLine();
				if (!s.equals("")) {
					arg[i] = s;
					i++;
				}

			}
			fs.close();
			in.close();
			br.close();
		} catch (Exception e) {
		}
		return arg;
	}

	public void Write_in_file(String str, String agr[]) {
		int i = 0;
		try {
			if (agr[0].length() == 0 || str == null)
				return;

			File f = new File(str);
			FileWriter fr = new FileWriter(f, true);
			BufferedWriter w = new BufferedWriter(fr);
			while (i < agr.length) {
				w.newLine();

				w.write(agr[i]);
				i++;

			}
			w.close();
		} catch (Exception e) {
		}
	}

	public int calcule(String s) {
		int j1 = 0;

		try {

			File f;
			f = new File(s);
			FileInputStream fs = null;
			InputStreamReader in = null;
			BufferedReader br = null;
			fs = new FileInputStream(f);
			in = new InputStreamReader(fs);
			br = new BufferedReader(in);
			while (br.readLine() != null) {
				j1++;
			}

			fs.close();
			in.close();
			br.close();
		} catch (Exception e) {
		}
		return j1;
	}
}
