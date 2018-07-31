import java.util.ArrayList;
import javax.swing.JButton;



public class Grid {

		private ArrayList<JButton> gridValues;

		private static final int MAX = 27;

		String winner = " ";

		public Grid() {
			initializeGrid();
		}

		public void updateGrid(int getNum, String btnText) {
				gridValues.set(getNum, new JButton(btnText));
		}

		private void initializeGrid(){
			gridValues = new ArrayList<JButton>();
			for(int i = 0; i < MAX; i++){
				JButton btn = new JButton(" ");
				btn.setActionCommand("" + i);
				gridValues.add(btn);
			}
		}

		public void resetGrid(){
		    initializeGrid();
		}

		public JButton getCell(int num){
			return gridValues.get(num);
		}

		public ArrayList<JButton> getValues(){ return gridValues; }

		public boolean checkWin(String symbol){
			if(checkHor()){
				winner = symbol;
				return true;
			}
			 if(checkDag()){
				winner = symbol;
			return true;
			}
			if(checkVer()){
				winner = symbol;
				return true;
			}
			return false;
		}

		private boolean checkHor(){
			for(int i = 0; i < MAX-2; i++){
				if(gridValues.get(i).getText().equals((gridValues).get(i+1).getText())){
					if(gridValues.get(i+1).getText().equals((gridValues).get(i+2).getText()))
						if(gridValues.get(i).getText().matches("[a-zA-Z]"))
							return true;
				}
			}
			for(int i = 0; i < MAX-6; i++){
				if(gridValues.get(i).getText().equals((gridValues).get(i+3).getText())){
					if(gridValues.get(i+3).getText().equals((gridValues).get(i+6).getText()))
						if(gridValues.get(i).getText().matches("[a-zA-Z]"))
							return true;
				}
			}
			return false;
		}

		private boolean checkDag() {

			for(int i = 0; i < 9; i++){
			if(gridValues.get(i).getText().matches("[a-zA-Z]")){
				if(gridValues.get(i).getText().equals(gridValues.get(i+6).getText())){
					if(gridValues.get(i+6).getText().equals(gridValues.get(i+12).getText()))
						return true;
				}
			}
			}


			for(int i = 0; i < 9; i++){
				if(i < 7){
					if( i < 4 )
						if(gridValues.get(i).getText().matches("[a-zA-Z]"))
							if(gridValues.get(i).getText().equals(gridValues.get(i+11).getText()))
								if(gridValues.get(i+11).getText().equals(gridValues.get(i+22).getText()))
									return true;
					if( i < 3 )
						if(gridValues.get(i).getText().matches("[a-zA-Z]"))
							if(gridValues.get(i).getText().equals(gridValues.get(i+12).getText()))
								if(gridValues.get(i+12).getText().equals(gridValues.get(i+24).getText()))
									return true;


					if(gridValues.get(i).getText().matches("[a-zA-Z]"))
						if(gridValues.get(i).getText().equals(gridValues.get(i+10).getText()))
							if(gridValues.get(i+10).getText().equals(gridValues.get(i+20).getText()))
									return true;
				} else {

					if(gridValues.get(i).getText().matches("[a-zA-Z]"))
						if(gridValues.get(i).getText().equals(gridValues.get(i+1).getText()))
							if(gridValues.get(i).getText().equals(gridValues.get(i+11).getText()))
								return true;
					if(gridValues.get(i).getText().matches("[a-zA-Z]")){
						if(gridValues.get(i).getText().equals(gridValues.get(i+8).getText())){
							if(gridValues.get(i+8).getText().equals(gridValues.get(i+16).getText()))
								return true;
						}
					}
				}
			}
			//Middle Dags
			if(gridValues.get(13).getText().matches("[a-zA-Z]")){
				if(gridValues.get(13).getText().equals(gridValues.get(0).getText())){
					if(gridValues.get(13).getText().equals(gridValues.get(26).getText()))
						return true;
				}else if(gridValues.get(13).getText().equals(gridValues.get(8).getText())){
					if(gridValues.get(13).getText().equals(gridValues.get(18).getText()))
						return true;
				}
			}
			//Side Dags
			if(gridValues.get(18).getText().matches("[a-zA-Z]")){
				if(gridValues.get(18).getText().equals(gridValues.get(22).getText())){
					if(gridValues.get(22).getText().equals(gridValues.get(26).getText()))
						return true;
				}
			}

			if(gridValues.get(20).getText().matches("[a-zA-Z]")){
				if(gridValues.get(20).getText().equals(gridValues.get(22).getText())){
					if(gridValues.get(22).getText().equals(gridValues.get(24).getText()))
						return true;
				}
			}

			if(gridValues.get(2).getText().matches("[a-zA-Z]")){
				if(gridValues.get(2).getText().equals(gridValues.get(4).getText())){
					if(gridValues.get(4).getText().equals(gridValues.get(6).getText()))
						return true;
				}
			}

			if(gridValues.get(0).getText().matches("[a-zA-Z]")){
				if(gridValues.get(0).getText().equals(gridValues.get(4).getText())){
					if(gridValues.get(4).getText().equals(gridValues.get(8).getText()))
						return true;
				}
			}
			//Middle Dags
			if(gridValues.get(9).getText().matches("[a-zA-Z]")){
				if(gridValues.get(9).getText().equals(gridValues.get(13).getText())){
					if(gridValues.get(13).getText().equals(gridValues.get(17).getText()))
						return true;
				}
			}

			if(gridValues.get(11).getText().matches("[a-zA-Z]")){
				if(gridValues.get(11).getText().equals(gridValues.get(13).getText())){
					if(gridValues.get(13).getText().equals(gridValues.get(15).getText()))
						return true;
				}
			}



			for(int i = 26; i >  18; i--){
				if(gridValues.get(i).getText().matches("[a-zA-Z]"))
					if(gridValues.get(i).getText().equals(gridValues.get(i-6).getText()))
						if(gridValues.get(i-6).getText().equals(gridValues.get(i-12).getText()))
							return true;

			}

			for(int i = 26; i > 17 ; i--){
				if(gridValues.get(i).getText().matches("[a-zA-Z]")){
					if(gridValues.get(i).getText().equals(gridValues.get(i-8).getText())){
						if(gridValues.get(i-8).getText().equals(gridValues.get(i-16).getText()))
							return true;
					}
				}
			}


			return false;

		}

		private boolean checkVer(){

			for(int i = 0; i < 6; i++){
				if(gridValues.get(i).getText().matches("[a-zA-Z]")){
					if(gridValues.get(i).getText().equals(gridValues.get(i+9).getText())){
						if(gridValues.get(i+9).getText().equals(gridValues.get(i+18).getText()))
							return true;
					}
					if(gridValues.get(i).getText().equals(gridValues.get(i+12).getText()))
						if(gridValues.get(i+12).getText().equals(gridValues.get(i+21).getText()))
							return true;

					if(gridValues.get(i).getText().equals(gridValues.get(i+6).getText()))
						if(gridValues.get(i+6).getText().equals(gridValues.get(i+15).getText()))
							return true;
				}
			}

			for(int i = 26; i > 18; i--){
				if(gridValues.get(i).getText().matches("[a-zA-Z]")){
					if(gridValues.get(i).getText().equals(gridValues.get(i-12).getText()))
						if(gridValues.get(i-12).getText().equals(gridValues.get(i-21).getText()))
							return true;
				if(i > 19)
					if(gridValues.get(i).getText().equals(gridValues.get(i-7).getText()))
						if(gridValues.get(i-7).getText().equals(gridValues.get(i-14).getText()))
							return true;
				}
			}
			return false;
		}
	}