/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midtermproject;
import java.util.Comparator;
/**
 *
 * 
 */
public class AlbumComparator  implements Comparator <Album> {
    
    public int compare(Album a, Album b) {
      
        
        return(a.getArtistName().compareToIgnoreCase(b.getArtistName())) ;
    
}
    }
