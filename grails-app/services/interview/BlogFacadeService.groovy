package interview

import com.lerss.ent.api.BlogEntryDTO
import com.lerss.ent.api.BlogFacade
import grails.transaction.Transactional

@Transactional
class BlogFacadeService implements BlogFacade{

    @Override
    List<BlogEntryDTO> getRecentEntries(int n){
    	def cri = BlogEntryDTO.createCriteria()
		def list = cri.list {
			maxResults(n)
			order("dateCreated", "desc")
		}
		
		list;
    }

    @Override
    void publish(BlogEntryDTO entry){
    	def saveBlog = entry
    	saveBlog.save(flush:true)
    }
}
