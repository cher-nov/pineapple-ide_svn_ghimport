/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pinedlcompiler.tree;

import pinedlcompiler.Token;

/**
 *
 * @author luis
 */
public class BooleanConstant extends ConstantNode{
    public boolean value = false;

    public BooleanConstant(Token t){
        super(t);
        if(t.type==Token.Type.TRUE){
            value = true;
        }
    }
}
