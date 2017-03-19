package pages

import geb.Page

class GithubPage extends Page {

    def titulo = "GitHub - pauloborba/ResS: residue management system"
    static url = "https://github.com/pauloborba/ResS"

    static at = {
        title ==~ titulo
    }
}
