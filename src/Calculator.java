import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JButton[] numberButtons = new JButton[10]; //Numbers from 0 to 9.
	private JButton[] functionButtons = new JButton[8]; //For all the operations.
	private JButton addButton, subButton, mulButton, divButton;
	private JButton decButton, equButton, delButton, clrButton;
	private Font myFont = new Font("Andes", Font.BOLD, 30);
	private double num1=0, num2=0, result=0;
	private char operator;
	
	public Calculator() {
		
		this.setLayout(null);
		
		//About TextField.
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		//About Buttons.
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		
		//Setting up function buttons.
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		
		for(int i=0; i<8; i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i=0; i<10; i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50, 430, 150, 50);
		clrButton.setBounds(200, 430, 150, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		//Adding buttons to the panel.
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		//About Frame.
		this.add(panel);
		this.add(textField);
		this.add(delButton);
		this.add(clrButton);
		this.setTitle("Calculator");
		this.setSize(420, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) 
				textField.setText(textField.getText().concat(String.valueOf(i)));
		}
		
		//About decimal button.
		if(e.getSource()==decButton)
			textField.setText(textField.getText().concat("."));
		
		//About add button.
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='+';
			textField.setText("");
		}

		//About subtraction button.
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='-';
			textField.setText("");
		}

		//About multiply button.
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='*';
			textField.setText("");
		}

		//About divide button.
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='/';
			textField.setText("");
		}

		//About equals button.
		if(e.getSource()==equButton) {
			
			num2=Double.parseDouble(textField.getText());
			
			switch(operator) {
			
			case'+':
				result=num1+num2;
				break;

			case'-':
				result=num1-num2;
				break;

			case'*':
				result=num1*num2;
				break;

			case'/':
				result=num1/num2;
				break;
			}

			textField.setText(String.valueOf(result));
			num1=result;
		}

		//About clear button.
		if(e.getSource()==clrButton)
			textField.setText("");

		//About delete button.
		if(e.getSource()==delButton) {
			String string = textField.getText();
			textField.setText("");

			for(int i=0;i<string.length()-1;i++) 
				textField.setText(textField.getText()+string.charAt(i));	

		}	
	}
}
