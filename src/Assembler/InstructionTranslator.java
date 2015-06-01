/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assembler;

<<<<<<< HEAD
import static GUI.GUI.InstructionTable;
=======
>>>>>>> 0d8593f5013ad0461213211f5b34f51523fb76f9
import java.util.ArrayList;
import java.util.HashMap;

/*! \brief  MAC1 Interpreter Class, Machine level class
 * 
 *  UNDER UPDATES
 *  It will take input machine code and bring it to the MIC1 components.
 *
 * @author Thiago G Goncalves
 */
public class InstructionTranslator {

    private final HashMap<String, Short> keymap = new HashMap<>();
    private final ArrayList<String> NoParemsInstruction = new ArrayList<>();
    private final ArrayList<String> jumpInstruction = new ArrayList<>();
    private static final InstructionTranslator instance = new InstructionTranslator();

    private InstructionTranslator() {
<<<<<<< HEAD
=======

        keymap.put("LODD", (short) 0);
        keymap.put("STOD", (short) 4096);
        keymap.put("ADDD", (short) 8192);
        keymap.put("SUBD", (short) 12288);
        keymap.put("JPOS", (short) 16384);
        keymap.put("JZER", (short) 20480);
        keymap.put("JUMP", (short) 24576);
        keymap.put("LOCO", (short) 28672);
        keymap.put("LODL", (short) -32768);
        keymap.put("STOL", (short) -28672);
        keymap.put("ADDL", (short) -24576);
        keymap.put("SUBL", (short) -20480);
        keymap.put("JNEG", (short) -16384);
        keymap.put("CALL", (short) -8192);

>>>>>>> 0d8593f5013ad0461213211f5b34f51523fb76f9
        jumpInstruction.add("JPOS");
        jumpInstruction.add("JZER");
        jumpInstruction.add("JUMP");
        jumpInstruction.add("JNEG");
        jumpInstruction.add("CALL");
<<<<<<< HEAD
         // keymap.put(".LOC", (short)0);

         // NoParemsInstruction.add(".LOC");

        this.parseSupportedInstruction();
    }
    protected void reset(){
        instance.keymap.clear();
        instance.NoParemsInstruction.clear();
         this.parseSupportedInstruction();
    }

    private void parseSupportedInstruction() {
        int row = InstructionTable.getModel().getRowCount();
        for (int i = 0; i < row; i++) {

            String instruction = "";
            short operandValue = 0;
            boolean argument = false;

            next:
            for (int j = 0; j < 2; j++) {
                String data = (String) InstructionTable.getModel().getValueAt(i, j).toString();

                switch (j) {
                    case 0:
                        if (data == null || data.isEmpty()) {

                            break next;
                        }
                        instruction = data.toUpperCase();
                        break;
                    case 1:

                        Object arg = InstructionTable.getModel().getValueAt(i, 2);
                        if (arg == null) {
                            argument = false;
                        } else {

                            int size = ((String) arg).length();
                            argument = size != 0;

                            for (int k = 0; k < size; k++) {
                                data = data + "0";
                            }
                        }
                        operandValue = (short) Integer.parseInt(data, 2);
                        break;
                }

            }

            keymap.put(instruction, operandValue);
            if (!argument) {
                this.NoParemsInstruction.add(instruction);
            }
        }
=======

        keymap.put("PSHI", (short) -4096);
        keymap.put("POPI", (short) -3584);
        keymap.put("PUSH", (short) -3072);
        keymap.put("POP", (short) -2560);
        keymap.put("RETN", (short) -2048);
        keymap.put("SWAP", (short) -1536);
        keymap.put("INSP", (short) -1024);
        keymap.put("DESP", (short) -512);
        keymap.put("HALT", (short) -256);
       // keymap.put(".LOC", (short)0);

       // NoParemsInstruction.add(".LOC");
        NoParemsInstruction.add("POP");
        NoParemsInstruction.add("PSHI");
        NoParemsInstruction.add("POPI");
        NoParemsInstruction.add("PUSH");
        NoParemsInstruction.add("RETN");
        NoParemsInstruction.add("SWAP");
        NoParemsInstruction.add("HALT");
>>>>>>> 0d8593f5013ad0461213211f5b34f51523fb76f9

    }

    protected static InstructionTranslator getInstance() {
<<<<<<< HEAD
        
=======
>>>>>>> 0d8593f5013ad0461213211f5b34f51523fb76f9
        return InstructionTranslator.instance;
    }

    protected boolean InstructionHasArgument(String str) {
        if (str == null) {
            return false;
        }
        str = str.toUpperCase();
        if (!isValid(str)) {

            return false;
        }
        for (String temp : NoParemsInstruction) {
            if (str.equals(temp)) {
                return false;
            }
        }
        return true;
    }

    protected boolean isJumpInstruction(String instruction) {
        instruction = instruction.toUpperCase();
        for (String temp : jumpInstruction) {
            if (instruction.equals(temp)) {
                return true;
            }
        }

        return false;
    }

    protected boolean isValid(String st) {
        if (st == null) {
            return false;
        }
        st = st.trim();
        st = st.toUpperCase();

        for (String str : keymap.keySet()) {
            if (str.equals(st)) {
                return true;
            }
        }

        return false;
    }

    protected boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

<<<<<<< HEAD
    protected ArrayList<String> translate(ArrayList<String> instructions) {

        final ArrayList<String> decodedInstruction = new ArrayList<>();
        for (String instruction_temp : instructions) {
            short decoded;
            instruction_temp = instruction_temp.toUpperCase();
            String[] instruction_array = instruction_temp.split(" ");
            
            if (InstructionHasArgument(instruction_array[0])) {
                decoded = keymap.get(instruction_array[0]);
               // System.out.println(decoded);
                decoded += Short.valueOf(instruction_array[1]);
               // System.out.println("ALL : "+decoded);
            } else {
                decoded = keymap.get(instruction_array[0]);
            }
            decodedInstruction.add(decoded + "#" + instruction_temp);
=======
    protected ArrayList<Short> translate(ArrayList<String> instructions) {
        
        final ArrayList<Short> decodedInstruction = new ArrayList<>();
        for (String instruction_temp : instructions) {
            short decoded ;
            instruction_temp = instruction_temp.toUpperCase();
            String[] instruction_array = instruction_temp.split(" ");
            if (InstructionHasArgument(instruction_array[0])) {
                decoded = keymap.get(instruction_array[0]);
                decoded += Short.valueOf(instruction_array[1]);
            } else {
                decoded = keymap.get(instruction_array[0]);
            }
            decodedInstruction.add(decoded);
>>>>>>> 0d8593f5013ad0461213211f5b34f51523fb76f9
        }
        return decodedInstruction;
    }
}
