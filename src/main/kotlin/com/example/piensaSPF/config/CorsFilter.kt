import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CorsFilter : Filter {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpResponse = response as HttpServletResponse
        httpResponse.setHeader("Access-Control-Allow-Origin", "*")
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH")
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization")
        httpResponse.setHeader("Access-Control-Max-Age", "3600")
        if ("OPTIONS".equals((request as HttpServletRequest)?.method, ignoreCase = true)) {
            httpResponse.status = HttpServletResponse.SC_OK
        } else {
            chain?.doFilter(request, response)
        }
    }

    override fun init(filterConfig: FilterConfig?) {}

    override fun destroy() {}
}
