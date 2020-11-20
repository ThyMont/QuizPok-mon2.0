package view;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Index {

	public static void main(String[] args) {
		Session session;
		/*SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		Pokemon[] lista = {new Pokemon("#005","Charmeleon","Chama","Quando ele balança a cauda, eleva a temperatura a níveis insuportavelmente altos.",1.1,19.0,1,new Tipo("Fire"),new Tipo("noType")),
		new Pokemon("#006","Charizard","Chama","Cospe fogo que é quente o suficiente para derreter pedras. Conhecido por causar incêndios florestais sem intenção.",1.7,90.5,1,new Tipo("Fire"),new Tipo("Flying")),
		new Pokemon("#007","Squirtle","Pequena Tartaruga","Após o nascimento, suas costas incham e endurecem em uma concha. Potencialmente pulveriza espuma da boca.",0.5,9.0,1,new Tipo("Water"),new Tipo("noType")),
		new Pokemon("#008","Wartortle","Tartaruga","Muitas vezes se esconde na água para perseguir presas desavisadas. Para nadar rápido, ele move as orelhas para manter o equilíbrio.",1.0,22.5,1,new Tipo("Water"),new Tipo("noType")),
		new Pokemon("#009","Blastoise","Marisco","Um brutal com jatos de água pressurizada em sua concha. Eles são usados para ataques de alta velocidade.",1.6,85.5,1,new Tipo("Water"),new Tipo("noType")),
		new Pokemon("#010","Caterpie","Verme","Seus pés curtos são cobertos com ventosas que permitem que você suba incansavelmente em declives e paredes.",0.3,2.9,1,new Tipo("Bug"),new Tipo("noType")),
		new Pokemon("#011","Metapod","Casulo","Este é vulnerável ao ataque enquanto sua casca é macia, expondo seu corpo fraco e terno.",0.7,9.9,1,new Tipo("Bug"),new Tipo("noType")),
		new Pokemon("#012","Butterfree","Borboleta","Em batalha, bate as asas em alta velocidade para liberar poeira altamente tóxica no ar.",1.1,32.0,1,new Tipo("Bug"),new Tipo("Flying")),
		new Pokemon("#013","Weedle","Inseto Peludo","Muitas vezes encontrado em florestas, comendo folhas. Tem um ferrão venenoso afiado em sua cabeça.",0.3,3.2,1,new Tipo("Bug"),new Tipo("Poison")),
		new Pokemon("#014","Kakuna","Casulo","Quase incapaz de se mover, este só pode endurecer sua concha para se proteger de predadores.",0.6,10.0,1,new Tipo("Bug"),new Tipo("Poison")),
		new Pokemon("#015","Beedrill","Abelha Venenosa","Voa em alta velocidade e ataca usando seus grandes ferrões venenosos em suas patas dianteiras e cauda.",1.0,29.5,1,new Tipo("Bug"),new Tipo("Poison")),
		new Pokemon("#016","Pidgey","Passarinho","Uma visão comum em florestas e bosques. Ele bate as asas no nível do solo para chocar areia ofuscante.",0.3,1.8,1,new Tipo("Normal"),new Tipo("Flying")),
		new Pokemon("#017","Pidgeotto","Pássaro","Muito protetor de sua extensa área territorial, este vai ferver ferozmente qualquer intruso.",1.1,30.0,1,new Tipo("Normal"),new Tipo("Flying")),
		new Pokemon("#018","Pidgeot","Pássaro","Ao caçar, ele percorre a superfície da água em alta velocidade para capturar presas incautas como Magikarp.",1.5,39.5,1,new Tipo("Normal"),new Tipo("Flying")),
		new Pokemon("#019","Rattata","Rato","Morda tudo quando ataca. Pequeno e muito rápido, é uma visão comum em muitos lugares.",0.3,3.5,1,new Tipo("Normal"),new Tipo("noType")),
		new Pokemon("#020","Raticate","Rato","Ele usa seus bigodes para manter o equilíbrio. Aparentemente diminui se eles são cortados.",0.7,18.5,1,new Tipo("Normal"),new Tipo("noType")),
		new Pokemon("#021","Spearow","Passarinho","Come insetos em áreas gramadas. Ele tem que bater suas asas curtas em alta velocidade para ficar no ar.",0.3,2.0,1,new Tipo("Normal"),new Tipo("Flying")),
		new Pokemon("#022","Fearow","Bico","Com suas enormes e magníficas asas, pode manter-se no ar sem ter que pousar para descansar.",1.2,38.0,1,new Tipo("Normal"),new Tipo("Flying")),
		new Pokemon("#023","Ekans","Serpente","Move-se silenciosa e furtivamente. Come os ovos de aves, como Pidgey e Spearow, inteiros.",2.0,6.9,1,new Tipo("Poison"),new Tipo("noType")),
		new Pokemon("#024","Arbok","Cobra","Há rumores de que as marcações de aviso ferozes em sua barriga diferem de área para área.",3.5,65.0,1,new Tipo("Poison"),new Tipo("noType")),
		new Pokemon("#025","Pikachu","Rato","Quando vários desses se reúnem, sua eletricidade pode se acumular e causar tempestades elétricas.",0.4,6.0,1,new Tipo("Electric"),new Tipo("noType")),
		new Pokemon("#026","Raichu","Rato","Sua cauda longa serve como um terreno para se proteger de sua própria energia de alta tensão.",0.8,30.0,1,new Tipo("Electric"),new Tipo("noType")),
		new Pokemon("#027","Sandshrew","Rato","Abre buracos no subsolo em locais áridos, longe da água. Só sai em busca de comida.",0.6,12.0,1,new Tipo("Ground"),new Tipo("noType")),
		new Pokemon("#028","Sandslash","Rato","Se enrola em uma bola espinhosa quando ameaçada. Pode rolar enquanto enrolado para atacar ou escapar.",1.0,29.5,1,new Tipo("Ground"),new Tipo("noType"))};
*/
		
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			
			session.close();
			
		}catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}
	
	
}