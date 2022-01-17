import { ReactComponent as GitHubIcon } from "assets/img/github.svg";
import "./styles.css";

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="dsmovie-nav-container">
          <h1>DSMovie</h1>
          <a href="https://github.com/AlexFMoura/dsmovie">
            <div className="dsmovie-contact-container">
              <GitHubIcon />
              <p className="dsmovie-contact-link">/alexfmoura</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
