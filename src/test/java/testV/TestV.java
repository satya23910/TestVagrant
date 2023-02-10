package testV;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestV {
		JSONObject jsonObject = new JSONObject(jsonClass.str);
		JSONArray jsonArray = jsonObject.getJSONArray("player");
		
		@Test(description="Validation of only four foreign Players are allowed")
		public void OnlyFourForeignPlayers()
		{
			int countOfForeignPlayers =0;
			final int  numbersOfForeignPlayersAllowed =4;
			for(int i=0;i<jsonArray.length();i++)
			{
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String country = jsonObject.getString("country");
				if(!(country.equalsIgnoreCase("India")))
					countOfForeignPlayers++;
			}
			Assert.assertEquals(numbersOfForeignPlayersAllowed, countOfForeignPlayers);
		}
		
		@Test(description = "Validation of at least one wicket keeper")
		public void AtLeastOneWicketKeeper()
		{
			boolean countOfWicketKeeper =false;
			for(int i=0;i<jsonArray.length();i++)
			{
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String country = jsonObject.getString("role");
				if(!(country.equalsIgnoreCase("Wicket-keeper")))
				{
					countOfWicketKeeper = true;
					break;
				}
			}
			Assert.assertTrue(countOfWicketKeeper);
		}
		
	}
