package se.webdev.ju15.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetMessage
 * @author Joakim
 */
@WebServlet("/Links")
public class Links extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String text = "";

		String urlBit = "";
		urlBit = req.getRequestURI().substring(req.getRequestURI().length() - 2, req.getRequestURI().length());

		switch (urlBit) {
		case "/b": text = "<div class='col-md-12 bar' style='padding:0px'><img class='barimg' src='pics/bar.jpg'></div><div><p>"
				+ "<br><br>"
				+ "Bar Nombre: Välbesökt bar med moderna spanskinfluenser. Bar Nombre öppnade 2011 och utgör Stockholms svar på en spansk cerveceria (ölhak). Bardelen, som framåt kvällen brukar bli knökfull, är inte minst känd för sitt utbud av cava, brandy och välblandade cocktails. Ett riktigt dragplåster bland stans drinksugna som inte är rädda för att trängas. Mer information: Bar Nombre, Odengatan 36, Vasastan"
				+ "<br><br>"
				+ "Storstad: Obligatoriskt barhäng på Odenagatan. Sedan Storstad slog upp dörrarna 1999 har stället varit ett givet krogstopp i Vasastan bland allt från mediafolk och afterworkare till nyfikna turister, inte minst för barhängets skull. Sjunk ner bland de svarta läderfåtöljerna och lyssna på vad dj:n har att erbjuda, och missa så klart inte uteserveringen på Odengatan lagom till sommaren. Mer information: Storstad, Odengatan 41, Vasastan"
				+ "<br><br>"
				+ "Grodan: Stående klassiker. Oavsett om du är affärsman, dj eller helt vanlig barhoppare lär du hamna på Grodan förr eller senare. Idag är krogen snudd på institution på Grev Turegatan. Baren på övervåningen är ett alltid lika stimmigt tillhåll som har samlat många stammisar genom åren. Många tar något att dricka här innan det är dags för middag, men också för att stanna sent in på kvällen. Mer information: Grodan, Grev Turegatan 16, Östermalm";
			break;
		case "/c": text = "<div class='col-md-12 disco' style='padding:0px'><img class='discoimg' src='pics/disco.jpg'></div><div><p>"
				+ "<br><br>"
				+ "Live jazz & late-night club Fasching Jazzklubb. This place is a Stockholm icon that has been around since the 70s. It’s relaxed, lively and something altogether different to the regular Stockholm club scene. Locals come here to listen to live jazz and dance the night away to 60s and 70s beats"
				+ "<br><br>"
				+ "Hip Söder night spot Morfar Ginko. With guest DJs spicing up the weekends, lively mid-week ping-pong and a fantastic courtyard that’s open during the warmer months, Morfar Ginko is a Söder classic, and a stylish one at that."
				+ "<br><br>"
				+ "Opened in 2005, The White Room has a spacious, modern look, is painted a crisp white and adorned with fresh flowers. It actually looks more like a restaurant than a nightclub, but around 1am there's no doubt that serious partying is the order of the day. The White Room was an instant hit with the city's younger, moneyed circles. Metro Östermalmstorg, exit Stureplan. Minimum age of entry: 23 years."
				+ "</p></div>";
			break;
		case "/r":
			text = "<div class='col-md-12 food' style='padding:0px'><img class='foodimg' src='pics/food.jpg'></div><div><p>"
					+ "<br><br>"
					+ "BAKFICKAN Jakobs Torg 12, Norrmalm, Stockholm (00 46 8 676 5800; www.operakallaren.se). Bakfickan (The Back Pocket) is adjacent to the Opera Bar and Operakällaren (see below). The restaurant serves Swedish classics such as meatballs in gravy and mashed potatoes, and the staff are lovely.<br><br>"
					+ "CARLSHALLS GARD Långholmen, Södermalm, Stockholm (00 46 8 668 0710; www.carlshallsgard.se). An opulent dining room awaits in this modest 19th-century mansion house on Långholmen, a small island between Södermalm and Kungsholmen. Långholmen used to house a prison and the mansion house, which was built by the prison governor, is the closest you will come to rural beauty in Stockholm. The food is seasonal and traditionally Swedish. Come during autumn or winter, and you might just find elk on the menu.<br><br>"
					+ "DJURET In the Victory Hotel, Lilla Nygatan 5, Gamla Stan, Stockholm (00 46 8 506 400 84; www.djuret.se). Djuret (meaning 'The Animal') would be a vegetarian's nightmare. Every week it pairs a different meat with a suitable wine: reindeer & Côtes du Rhône, for instance, or Cow & Chardonnay."
					+ "</p></div>";
			break;
		case "/a":
			text = "<div class='col-md-12 showText'><div class='col-md-3 image'><img class='linkimages' src='pics/grönalund.jpg'/><img class='linkimages' src='pics/vasa.gif'/><img class='linkimages' src='pics/skärgård.jpg'/></div>"
					+ "<div><p>Gröna Lund is an amusement park in Stockholm, Sweden. It is located on the seaward side of the Djurgården island and is relatively small compared to other amusement parks, mainly due to its central location, which limits expansion. The 15-acre amusement park has over 30 attractions, and is a popular venue for concerts during the summer. Gröna Lund was founded in 1883 by James Schultheiss."
					+ "<br><br>"
					+ "Vasa is a Swedish warship built between 1626 and 1628. The ship foundered and sank after sailing about 1,300 m (1,400 yd) into her maiden voyage on 10 August 1628. She fell into obscurity after most of her valuable bronze cannons were salvaged in the 17th century until she was located again in the late 1950s in a busy shipping lane just outside the Stockholm harbor."
					+ "<br><br>"
					+ "The Stockholm archipelago (Swedish: Stockholms skärgård) is the largest archipelago in Sweden, and the second-largest archipelago in the Baltic Sea (the largest being across the Baltic in Finland). </p></div>";
			break;
		}

		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(text);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}