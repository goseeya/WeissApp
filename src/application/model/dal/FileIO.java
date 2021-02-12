package application.model.dal;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FileIO {
	
		
		public ObservableList<Painting> getPaintings(String path) {
			Scanner in=null;
			ObservableList<Painting> paintings = FXCollections.observableArrayList();

			try {
				path = path != null ? path : "src/application/model/dal/sampleData.txt";
				in=new Scanner(Paths.get(path));

				while(in.hasNext()) {
					Painting painting = new Painting();

					painting.setPaintingId(in.next());
					painting.setTitle(in.next());
					painting.setFirstName(in.next());
					painting.setLastName(in.next());
					painting.setShape(in.next());
					painting.setWidth(in.next());
					painting.setHeight(in.next());
					painting.setRadius(in.next());
					painting.setArea(in.next());
					painting.setWeight(in.next());
					painting.setPrice(in.next());

					paintings.add(painting);
					System.out.println("Wczytane dane");

				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in!= null) {
					in.close();
				}
			}
			// observableList return 
			return paintings;
		}
	}

