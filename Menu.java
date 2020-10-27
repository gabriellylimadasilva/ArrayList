
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
Implementar uma agenda de pessoas com nome e fone, ambos do tipo String. A agenda deve funcionar com um menu de opções numéricas 
(0 - Sair, 1- Incluir nome e fone, 2- Alterar fone, 3- Consultar fone, 4- Excluir, 5- Listar agenda). As funcionalidades são:
1 - Incluir onde se inclui nome e fone
2 - Alterar onde você passa o nome e depois o novo fone
3 - Consulta onde você passa o nome e a agenda retorna o fone
4 - Excluir onde você passa o nome e a pessoa é retirada da agenda 
5 - Listar onde toda os nomes e fones serão apresentados      
Obs.: Baseie-se no código apresentado pelo Prof. Bossini na aula teórica.
 */

public class Menu {
   public static void main(String[] args) {
       String menu = "1- Incluir nome e fone\n2- Alterar fone\n3- Consultar fone\n4- Excluir\n5- Listar agenda\n0 - Sair";
       int opcao;
       

       List <Agenda> agendas = new ArrayList <>(); 
       
       do{
           opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
           switch(opcao){
                
                case 1:
                    String nome = JOptionPane.showInputDialog("Qual o nome?").toLowerCase();
                    String telefone = JOptionPane.showInputDialog("Qual o telefone?"); 
                    Agenda agenda = new Agenda (nome,telefone);                   
                    agendas.add(agenda);
                    JOptionPane.showMessageDialog(null, "Nome e Telefone inseridos com sucesso!!");
                    break;
                
                case 2:
                    String nome1 = JOptionPane.showInputDialog("Qual o nome?").toLowerCase();;
                    for(int i =0; i<agendas.size(); i++)
                    {
                        if(agendas.get(i).getNome().equals(nome1))
                        {
                            String novotelefone = JOptionPane.showInputDialog("Qual o seu novo telefone?");
                            agendas.get(i).setTelefone(novotelefone);
                            JOptionPane.showMessageDialog(null, "Telefone Alterado com sucesso!!");
                        }
                    }
                   break;              
                case 3:
                    String nome3 = JOptionPane.showInputDialog("Qual o nome?").toLowerCase();;
                    
                    for(int i=0; i < agendas.size(); i++)
                    {
                        if(agendas.get(i).getNome().equals(nome3))
                        {
                            String telefone3 = agendas.get(i).getTelefone();
                            JOptionPane.showMessageDialog(null, "nome "+ nome3+ " Telefone: " +telefone3); 
                        }
                    }
                    break;
                case 4:
                    String nome4 = JOptionPane.showInputDialog("Qual o nome que deseja remover?").toLowerCase();
                    
                    for(int i =0; i < agendas.size(); i++)
                    {
                        if(agendas.get(i).getNome().equals(nome4))
                        {
                            agendas.remove(i);
                            JOptionPane.showMessageDialog(null, "removido com sucesso \n" + nome4);
                        }
                    }
                    break;
                case 5:
                    String msg = "";
                    for(int i =0; i < agendas.size(); i++)
                    {
                        msg = msg +"Nome: " + agendas.get(i).getNome() + "\n" + "Telefone: "+ agendas.get(i).getTelefone() + "\n";
                    }
                    
                    if(msg != "")
                    {
                        JOptionPane.showMessageDialog(null,msg);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Lista vazia");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Até mais ver");
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Opção inválida");
                    break;

           }
        }while (opcao != 0);
    } 
}
