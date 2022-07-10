package dj.hegi.finished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PLSorter {
	private File _filename;
	private File _destfilename;
	private File _filename2;
	private List<String> _list = new ArrayList<String>();
	private String[] _lines;
	private List<String> _list2 = new ArrayList<String>();
	private String[] _lines2;
	private String[] _lines3;
	private int _countCmEb;
	private int _countGmBb;
	private int _countDmF;
	private int _countAmC;
	private int _countEmG;
	private int _countBmD;
	private int _countFHmA;
	private int _countDbmE;
	private int _countAbmB;
	private int _countEbmFH;
	private int _countBbmDb;
	private int _countFmAb;
	private boolean _error;
	private boolean wrong;

	public PLSorter(File filename, File filename2) {
		_filename = filename;
		_destfilename = filename;
		_filename2 = filename2;
		_error = false;
		wrong = false;
	}

	public void readTxt() {

		String line = null;

		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(_filename2), "UTF-16"));
			while ((line = bufferedReader.readLine()) != null) {
				_list.add(line);
			}

			bufferedReader.close();
			_lines = new String[_list.size()];
			for (int j = 0; j < _lines.length; j++) {

				_lines[j] = _list.get(j).toString();
			}
			/*for(int i = 0; i<_lines.length; i++) {
				System.out.println(_lines[i].toString());
				}*/

		} catch (FileNotFoundException ex) {
			System.out.println("Die Datei '" + _filename2 + "' kann nicht geöffnet werden.");
			_error = true;
		} catch (IOException ex) {
			System.out.println("Error reading file '" + _filename2 + "'");
			_error = true;
		}

	}

	public void readMu() {

		String line = null;

		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(_filename), "UTF8"));
			while ((line = bufferedReader.readLine()) != null) {
				_list2.add(line);
			}

			bufferedReader.close();
			_lines2 = new String[_list2.size()];
			_lines3 = new String[_list2.size()];
			for (int j = 0; j < _lines2.length; j++) {

				_lines2[j] = _list2.get(j).toString();
				_lines3[j] = _list2.get(j).toString();
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Die Datei '" + _filename + "' kann nicht geöffnet werden.");
			_error = true;
		} catch (IOException ex) {
			System.out.println("Error reading file '" + _filename + "'");
			_error = true;
		}

	}

	public void export() {

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(_destfilename), "UTF8"));
			int i = 0;
			while (i < _lines2.length && _lines2[i] != null) {
				bufferedWriter.write(_lines2[i]);
				bufferedWriter.newLine();

				i++;
			}
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + _destfilename + "'");
		}
	}

	// nach Keys sortieren
	public void sortKeys() {

		int j = 1;
		int k = 1;
		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'C') && (_lines[j].charAt(length) == 'm'))
					|| ((_lines[j].charAt(length - 1) == 'E') && (_lines[j].charAt(length) == 'b'))) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countCmEb++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'G') && (_lines[j].charAt(length) == 'm'))
					|| ((_lines[j].charAt(length - 1) == 'B') && (_lines[j].charAt(length) == 'b'))) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countGmBb++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'D') && (_lines[j].charAt(length) == 'm'))
					|| (_lines[j].charAt(length) == 'F')) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countDmF++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'A') && (_lines[j].charAt(length) == 'm'))
					|| (_lines[j].charAt(length) == 'C')) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countAmC++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'E') && (_lines[j].charAt(length) == 'm'))
					|| (_lines[j].charAt(length) == 'G')) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countEmG++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'B') && (_lines[j].charAt(length) == 'm'))
					|| (_lines[j].charAt(length) == 'D')) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countBmD++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 2)) == 'F') && ((_lines[j].charAt(length - 1)) == '#')
					&& (_lines[j].charAt(length) == 'm')) || (_lines[j].charAt(length) == 'A')) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countFHmA++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 2)) == 'D') && ((_lines[j].charAt(length - 1)) == 'b')
					&& (_lines[j].charAt(length) == 'm')) || (_lines[j].charAt(length) == 'E')) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countDbmE++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 2)) == 'A') && ((_lines[j].charAt(length - 1)) == 'b')
					&& (_lines[j].charAt(length) == 'm')) || (_lines[j].charAt(length) == 'B')
					|| (((_lines[j].charAt(length - 2)) == 'G') && ((_lines[j].charAt(length - 1)) == '#')
							&& (_lines[j].charAt(length) == 'm'))) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countAbmB++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 2)) == 'E') && ((_lines[j].charAt(length - 1)) == 'b')
					&& (_lines[j].charAt(length) == 'm'))
					|| ((_lines[j].charAt(length - 1) == 'F') && (_lines[j].charAt(length) == '#'))) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countEbmFH++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 2)) == 'B') && ((_lines[j].charAt(length - 1)) == 'b')
					&& (_lines[j].charAt(length) == 'm'))
					|| ((_lines[j].charAt(length - 1) == 'D') && (_lines[j].charAt(length) == 'b'))) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countBbmDb++;
			}
			j++;
		}
		j = 0;

		while (j < _lines.length) {
			int length = _lines[j].length() - 1;
			if ((((_lines[j].charAt(length - 1)) == 'F') && (_lines[j].charAt(length) == 'm'))
					|| ((_lines[j].charAt(length - 1) == 'A') && (_lines[j].charAt(length) == 'b'))) {
				String tempString = _lines[k];
				_lines[k] = _lines[j];
				_lines[j] = tempString;
				k++;
				_countFmAb++;
			}
			j++;
		}

	}

	// nach Bpm sortieren
	public void sortBpm() {
		int i = 1;
		int j = 1;
		int zahli = 0;
		int zahlj = 0;
		boolean upwards = true;
		if (_countCmEb >= 2) {

			while (i < _countCmEb + 1) {
				while (j < i) {
					if ((_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if ((_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (zahli < zahlj) {
						String tempstring = _lines[j];
						_lines[j] = _lines[i];
						_lines[i] = tempstring;

					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = 1;
				i++;
			}
			upwards = false;
		}

		i = 1 + _countCmEb;
		j = i;

		int defaultj = j;
		if (_countGmBb >= 2) {
			int until = _countGmBb + i;
			while (i < until) {
				while (j < i) {
					if ((_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if ((_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}

		i = 1 + _countCmEb + _countGmBb;
		j = i;
		defaultj = j;
		if (_countDmF >= 2) {
			int until = _countDmF + i;
			while (i < until) {
				while (j < i) {

					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'F')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'F') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'F')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'F') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}

		i = 1 + _countCmEb + _countGmBb + _countDmF;
		j = i;

		defaultj = j;
		if (_countAmC >= 2) {
			int until = _countAmC + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'C')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'C') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'C')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'C') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC;
		j = i;

		defaultj = j;
		if (_countEmG >= 2) {
			int until = _countEmG + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'G')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'G') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'G')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'G') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG;
		j = i;

		defaultj = j;
		if (_countBmD >= 2) {
			int until = _countBmD + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'D')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'D') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'D')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'D') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD;
		j = i;

		defaultj = j;
		if (_countFHmA >= 2) {
			int until = _countFHmA + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (10 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'A')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'A') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (10 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'A')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'A') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA;
		j = i;

		defaultj = j;
		if (_countDbmE >= 2) {
			int until = _countDbmE + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (10 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'E')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'E') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (10 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'E')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'E') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE;
		j = i;

		defaultj = j;
		if (_countAbmB >= 2) {
			int until = _countAbmB + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (10 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'B')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'B') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (7 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (10 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'B')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'B') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (7 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE
				+ _countAbmB;
		j = i;

		defaultj = j;
		if (_countEbmFH >= 2) {
			int until = _countEbmFH + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (10 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == '#')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == '#') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (10 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == '#')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == '#') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE
				+ _countAbmB + _countEbmFH;
		j = i;

		defaultj = j;
		if (_countBbmDb >= 2) {
			int until = _countBbmDb + i;
			while (i < until) {
				while (j < i) {
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'm')
							&& (_lines[i].charAt(_lines[i].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (10 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[i].charAt(_lines[i].length() - 1)) == 'b')
							&& (_lines[i].charAt(_lines[i].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else if ((_lines[i].charAt(_lines[i].length() - 1)) == 'b') {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'm')
							&& (_lines[j].charAt(_lines[j].length() - 10)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (10 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'm') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					}
					if (((_lines[j].charAt(_lines[j].length() - 1)) == 'b')
							&& (_lines[j].charAt(_lines[j].length() - 8)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else if ((_lines[j].charAt(_lines[j].length() - 1)) == 'b') {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}
		i = 1 + _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE
				+ _countAbmB + _countEbmFH + _countBbmDb;
		j = i;

		defaultj = j;
		if (_countFmAb >= 2) {
			int until = _countFmAb + i;
			while (i < until) {
				while (j < i) {
					if ((_lines[i].charAt(_lines[i].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (9 - l))) - 48);

						}
					} else {
						for (int l = 0; l < 2; l++) {
							zahli = zahli * 10 + ((_lines[i].charAt(_lines[i].length() - (8 - l))) - 48);

						}
					}
					if ((_lines[j].charAt(_lines[j].length() - 9)) == '1') {
						for (int l = 0; l < 3; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (9 - l))) - 48);

						}
					} else {
						for (int l = 0; l < 2; l++) {
							zahlj = zahlj * 10 + ((_lines[j].charAt(_lines[j].length() - (8 - l))) - 48);

						}
					}
					if (upwards == false) {
						if (zahli > zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;

						}
					} else if (upwards == true) {
						if (zahli < zahlj) {
							String tempstring = _lines[j];
							_lines[j] = _lines[i];
							_lines[i] = tempstring;
						}
					}
					zahli = 0;
					zahlj = 0;
					j++;
				}
				j = defaultj;
				i++;
			}
			if (upwards == false) {
				upwards = true;
			} else {
				upwards = false;
			}
		}

	}

	// Moll an erste/letzte Stelle
	public void sortMoll() {
		int i = 1;
		int j = 2;
		String tempstring;
		boolean found = false;
		if (_countCmEb >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < _countCmEb && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = _countCmEb - 1;
			i = _countCmEb;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + 1;
		j = _countCmEb + 2;
		if (_countGmBb >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < _countCmEb + _countGmBb && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = _countCmEb + _countGmBb - 1;
			i = _countCmEb + _countGmBb;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + 1;
		j = _countCmEb + _countGmBb + 2;
		if (_countDmF >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countDmF - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = _countCmEb + _countGmBb + _countDmF - 1;
			i = _countCmEb + _countGmBb + _countDmF;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + 1;
		j = _countCmEb + _countGmBb + _countDmF + 2;
		if (_countAmC >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countAmC - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = _countCmEb + _countGmBb + _countDmF + _countAmC - 1;
			i = _countCmEb + _countGmBb + _countDmF + _countAmC;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + 1;
		j = i + 1;
		if (_countEmG >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countEmG - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG - 1;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + 1;
		j = i + 1;
		if (_countBmD >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countBmD - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countBmD - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + 1;
		j = i + 1;
		if (_countFHmA >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countFHmA - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countFHmA - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + 1;
		j = i + 1;
		if (_countDbmE >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countDbmE - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countDbmE - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE + 1;
		j = i + 1;
		if (_countAbmB >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countAbmB - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countAbmB - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE
				+ _countAbmB + 1;
		j = i + 1;
		if (_countEbmFH >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countEbmFH - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countEbmFH - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE
				+ _countAbmB + _countEbmFH + 1;
		j = i + 1;
		if (_countBbmDb >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countBbmDb - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countBbmDb - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}
		found = false;
		i = _countCmEb + _countGmBb + _countDmF + _countAmC + _countEmG + _countBmD + _countFHmA + _countDbmE
				+ _countAbmB + _countEbmFH + _countBbmDb + 1;
		j = i + 1;
		if (_countFmAb >= 3) {
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j < i + _countFmAb - 1 && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j++;
				}
			}
			int defaulti = i;
			j = i + _countFmAb - 2;
			i = j + 1;
			found = false;
			if (_lines[i].charAt(_lines[i].length() - 1) != 'm') {
				while (j > defaulti && found == false) {
					if (_lines[j].charAt(_lines[j].length() - 1) == 'm') {
						tempstring = _lines[i];
						_lines[i] = _lines[j];
						_lines[j] = tempstring;
						found = true;
					}
					j--;
				}
			}
		}

	}

	// Index �ndern
	/*
	 * public void sortIndex() { int i = 1; StringBuilder temp; while (i < 10 && i <
	 * _lines.length) { if ((_lines[i].charAt(1) <= '9' && _lines[i].charAt(1) >=
	 * '0') && (_lines[i].charAt(2) <= '9' && _lines[i].charAt(2) >= '0')) {
	 * _lines[i] = new StringBuilder(_lines[i]).deleteCharAt(1).toString();
	 * _lines[i] = new StringBuilder(_lines[i]).deleteCharAt(1).toString(); temp =
	 * new StringBuilder(_lines[i]); temp.setCharAt(0, (char) (i + '0')); _lines[i]
	 * = temp.toString(); } else if (_lines[i].charAt(1) <= '9' &&
	 * _lines[i].charAt(1) >= '0') { _lines[i] = new
	 * StringBuilder(_lines[i]).deleteCharAt(1).toString(); temp = new
	 * StringBuilder(_lines[i]); temp.setCharAt(0, (char) (i + '0')); _lines[i] =
	 * temp.toString(); } else { temp = new StringBuilder(_lines[i]);
	 * temp.setCharAt(0, (char) i); _lines[i] = temp.toString(); } i++; } int j = 0;
	 * int k = 1; while (i < 100 && i < _lines.length) { if ((_lines[i].charAt(1) <=
	 * '9' && _lines[i].charAt(1) >= '0') && (_lines[i].charAt(2) <= '9' &&
	 * _lines[i].charAt(2) >= '0')) { _lines[i] = new
	 * StringBuilder(_lines[i]).deleteCharAt(2).toString(); temp = new
	 * StringBuilder(_lines[i]); temp.setCharAt(0, (char) (k + '0'));
	 * temp.setCharAt(1, (char) (j + '0')); _lines[i] = temp.toString(); } else if
	 * (_lines[i].charAt(1) <= '9' && _lines[i].charAt(1) >= '0') { temp = new
	 * StringBuilder(_lines[i]); temp.setCharAt(0, (char) (k + '0'));
	 * temp.setCharAt(1, (char) (j + '0')); _lines[i] = temp.toString(); } else {
	 * temp = new StringBuilder(_lines[i]); temp.setCharAt(0, (char) (k + '0'));
	 * _lines[i] = temp.toString(); _lines[i] = new
	 * StringBuilder(_lines[i]).insert(1, Integer.toString(j)).toString(); } j++; if
	 * (j == 10) { j = 0; k++; } i++; } j = 0; k = 0; int l = 1; while (i < 1000 &&
	 * i < _lines.length) { if ((_lines[i].charAt(1) <= '9' && _lines[i].charAt(1)
	 * >= '0') && (_lines[i].charAt(2) <= '9' && _lines[i].charAt(2) >= '0')) { temp
	 * = new StringBuilder(_lines[i]); temp.setCharAt(0, (char) (l + '0'));
	 * temp.setCharAt(1, (char) (k + '0')); temp.setCharAt(2, (char) (j + '0'));
	 * _lines[i] = temp.toString(); } else if (_lines[i].charAt(1) <= '9' &&
	 * _lines[i].charAt(1) >= '0') { _lines[i] = new
	 * StringBuilder(_lines[i]).insert(2, Integer.toString(j)).toString(); temp =
	 * new StringBuilder(_lines[i]); temp.setCharAt(0, (char) (l + '0'));
	 * temp.setCharAt(1, (char) (k + '0')); _lines[i] = temp.toString(); } else {
	 * temp = new StringBuilder(_lines[i]); temp.setCharAt(0, (char) (l + '0'));
	 * _lines[i] = temp.toString(); _lines[i] = new
	 * StringBuilder(_lines[i]).insert(1, Integer.toString(k)).toString(); _lines[i]
	 * = new StringBuilder(_lines[i]).insert(2, Integer.toString(l)).toString(); }
	 * j++; if (j == 10) { j = 0; k++; } if (k == 10) { k = 0; l++; } i++; }
	 * 
	 * }
	 */

	public void sortMu() {
		/*for(int i = 0; i<_lines.length; i++) {
		System.out.println(_lines[i].toString());
		}
		for(int i = 0; i<_lines.length; i++) {
			System.out.println(_lines2[i].toString());
			}*/
		int index;
		for (int i = 1; i < _lines.length; i++) {
			index = _lines[i].charAt(0) - '0';
			if (_lines[i].charAt(1) <= '9' && _lines[i].charAt(1) >= '0') {
				index = index * 10 + (_lines[i].charAt(1) - '0');
			}
			if (_lines[i].charAt(2) <= '9' && _lines[i].charAt(2) >= '0') {
				index = index * 10 + (_lines[i].charAt(2) - '0');
			}
			
			_lines2[i * 2 - 1] = _lines3[index * 2 - 1];
			_lines2[i * 2] = _lines3[index * 2];
			
			
		}
	}

	// alles zusammen
	public void execute() {
		this.readTxt();
		this.readMu();
		if(_lines.length - 1 == _lines2.length / 2) {
		if (_error == false) {
			this.sortKeys();
			this.sortBpm();
			this.sortMoll();
			this.sortMu();
			this.export();
		}
		}else {
			wrong = true;
		}
	}
	
	public boolean getWrong() {
		return wrong;
	}

	

	// done booleans mit großer while schleife(alle auf true), geht nur in
	// unterschelifen wenn false oder alle methoden zwei mal, nur ausführen, wenn noch nicht gemacht
}