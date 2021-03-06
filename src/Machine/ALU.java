package Machine;

import GUI.TextFieldGui;
import javax.swing.JTextField;
import Tools.MIC1;
import EnumerationData.ComponentEnum;



/*! \brief  This class simulates the MIC1 ALU component.
*
 * It is implemented using the Singleton pattern.
 * Does four operation A+B, A and B, A, ~A.
 * Two flags if the data is Zero or Negative
 * 
 * @author Thiago G Goncalves
 */

public class ALU extends TextFieldGui {

    public boolean ZFLAG = false;
    public boolean NFLAG = false;
    
    final static private ALU instance = new ALU(GUI.GUI.alu);
   
    static public ALU getInstance(){
        return instance;
    } 

    private ALU(JTextField textField) {
        super(ComponentEnum.ALU, textField);
    }

    private void alu() {
     
        this.NFLAG = false;
        this.ZFLAG = false;
        int decimal = convert(Pipe.MemoryInstruction.getAlu());
        short data = 0;
        switch (decimal) {
            case 0:
                // A + B
                short decimalValueB = MIC1.MIC1_DATA.get(ComponentEnum.B_LATCH).getData();
                short decimalValueA = MIC1.MIC1_DATA.get(ComponentEnum.AMUX).getData();

                data = (short) (decimalValueA + decimalValueB);   
                break;
            case 1:
                // A & B
                short b = MIC1.MIC1_DATA.get(ComponentEnum.B_LATCH).getData();
                short a = MIC1.MIC1_DATA.get(ComponentEnum.AMUX).getData();

                data = (short) (a & b);
       
                break;
            case 2:
                data = MIC1.MIC1_DATA.get(ComponentEnum.AMUX).getData();
                break;
            case 3:
                short c = MIC1.MIC1_DATA.get(ComponentEnum.AMUX).getData();                
                data = (short) ~c;
                break;
        }

        if (data < 0) {
            this.NFLAG = true;
        } else if (data == 0) {
            this.ZFLAG = true;
        }
        this.setData(data);
       
    }

    @Override
    public void Operations() {
        super.Operations(); //To change body of generated methods, choose Tools | Templates.
        this.alu();
    }
    
        
}
