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
public class Reference extends ExpressionNode{
    public Reference(){}
    public Reference(Token t){
        super(t);
    }
}
